package com.springheaven.ing.ingapp.helper;


import com.springheaven.ing.ingapp.model.Frequency;
import com.springheaven.ing.ingapp.model.PeriodicOrderIntent;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PeriodicDepositHelperTestParameterized {


    PeriodicDepositHelper  periodicDepositHelper;

    private PeriodicOrderIntent createPeriodicOrder(BigDecimal amount, Frequency frequency, LocalDate startDate) {

        return PeriodicOrderIntent.builder().
                amount(amount).
                startDate(startDate).
                Frequency(frequency).
                build();
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

    @BeforeEach
    void setUp() {
        periodicDepositHelper= new PeriodicDepositHelper();
    }

//    @ParameterizedTest
//    @CsvSource({
//            "1020, DAILY, 2023-01-01, 2.79",
//            "1020, WEEKLY, 2023-01-01, 19.25",
//            "1020, MONTHLY, 2023-01-01, 85",
//            "1020, QUARTERLY, 2023-01-01, 255",
//            "1020, YEARLY, 2023-01-01, 1020",
//    })
//    void testCalcCurrentYearPeriodicDepositAmount(BigDecimal amount, Frequency frequency, String startDate, BigDecimal expected) {
//        // Given
//        PeriodicOrderIntent intent = createPeriodicOrder(amount, frequency, LocalDate.parse(startDate));
//
//        // When
//        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);
//
//        // Then
//        assertEquals(expected.setScale(2), result);
//    }


    @ParameterizedTest
    @CsvSource({
            "1020, DAILY, 2023-01-01",
            "1020, WEEKLY, 2023-01-01",
            "1020, MONTHLY, 2023-01-01",
            "1020, QUARTERLY, 2023-01-01",
            "1020, HALF_YEARLY, 2023-07-01",
            "1020, YEARLY, 2023-01-01"
    })
    void testCalcCurrentYearPeriodicDepositAmountNew(BigDecimal amount, Frequency frequency, LocalDate startDate) {
        // Given
        val expectedAmountToInvest= amount.divide(BigDecimal.valueOf(calculateNumberOfDepositsNewSwitch(frequency,startDate)),2, RoundingMode.HALF_UP);
        PeriodicOrderIntent intent = createPeriodicOrder(amount, frequency, startDate);
        // When
        BigDecimal investAmount = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        log.info("Method: testCalcCurrentYearPeriodicDepositAmountNew | Invested Amount: {}, Expected Amount to Invest: {}", investAmount, expectedAmountToInvest);
        // Then
        assertEquals(expectedAmountToInvest.setScale(2), investAmount);
    }

}
