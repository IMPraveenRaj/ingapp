package com.springheaven.ing.ingapp.helper;

import com.springheaven.ing.ingapp.model.Frequency;
import com.springheaven.ing.ingapp.model.PeriodicOrderIntent;
import lombok.val;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.Objects;

@Component
public class PeriodicDepositHelper {


    public BigDecimal calcCurrentYearPeriodicDepositAmount(PeriodicOrderIntent periodicOrderIntent) {

        return Objects.isNull(periodicOrderIntent.getAmount()) || Objects.isNull(periodicOrderIntent.getStartDate())
                ? BigDecimal.ZERO
                : periodicOrderIntent.getAmount().
                divide(BigDecimal.valueOf(calculateNumberOfDepositsNewSwitch(periodicOrderIntent.getFrequency(),  periodicOrderIntent.getStartDate())),
                2, RoundingMode.HALF_UP);

    }


    public BigDecimal calcNextYearMonthlyInvestAmount( BigDecimal amountNextYear) {
        return Objects.isNull(amountNextYear) || amountNextYear.equals(BigDecimal.ZERO)
                ? BigDecimal.ZERO
                : amountNextYear.divide(BigDecimal.valueOf(12),2,RoundingMode.HALF_UP);

    }

    private long calculateNumberOfDeposits(Frequency frequency, LocalDate startDate) {

        val endDate= LocalDate.of(startDate.getYear(), 12,31);
        switch (frequency) {
            case DAILY:
                return ChronoUnit.DAYS.between(startDate, endDate)+1;
            case WEEKLY:
                return ChronoUnit.WEEKS.between(startDate, endDate)+1;
            case MONTHLY:
                return ChronoUnit.MONTHS.between(startDate, endDate)+1;
            case QUARTERLY:
                return IsoFields.QUARTER_YEARS.between(startDate, endDate)+1;
            case HALF_YEARLY:
                return startDate.getMonthValue()>6 ?2 :1;
                default:
                    return 1;

        }

    }

    private long calculateNumberOfDepositsNewSwitch(Frequency frequency, LocalDate startDate) {
        LocalDate endDate = LocalDate.of(startDate.getYear(), 12, 31);

        return switch (frequency) {
            case DAILY -> ChronoUnit.DAYS.between(startDate, endDate) + 1;
            case WEEKLY -> ChronoUnit.WEEKS.between(startDate, endDate) + 1;
            case MONTHLY -> ChronoUnit.MONTHS.between(startDate, endDate) + 1;
            case QUARTERLY -> IsoFields.QUARTER_YEARS.between(startDate, endDate) + 1;
            case HALF_YEARLY -> startDate.getMonthValue() > 6 ? 2 : 1;
            default -> 1;
        };
    }
}
