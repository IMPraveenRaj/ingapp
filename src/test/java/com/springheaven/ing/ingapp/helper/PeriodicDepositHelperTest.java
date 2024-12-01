package com.springheaven.ing.ingapp.helper;




import com.springheaven.ing.ingapp.model.Frequency;
import com.springheaven.ing.ingapp.model.PeriodicOrderIntent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PeriodicDepositHelperTest {

    private PeriodicDepositHelper periodicDepositHelper;

    @BeforeEach
    void setUp() {
        periodicDepositHelper = new PeriodicDepositHelper();
    }
    private PeriodicOrderIntent createOrder(BigDecimal amount, Frequency frequency, LocalDate startDate) {

        return PeriodicOrderIntent.builder().
                amount(amount).
                startDate(startDate).
                Frequency(frequency).
                build();
    }
    @Test
    void testCalcCurrentYearPeriodicDepositAmount_DailyFrequency() {
        // Given
        PeriodicOrderIntent intent = PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(1020)); // Total amount
        intent.setFrequency(Frequency.DAILY);
        intent.setStartDate(LocalDate.of(2024, 1, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(result.setScale(2), result);
        // The number of deposits is 366 (2024 is a leap year), so the amount per deposit is 3650 / 366 = 10.00.
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_WeeklyFrequency() {
        // Given
        PeriodicOrderIntent intent =PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(520)); // Total amount
        intent.setFrequency(Frequency.WEEKLY);
        intent.setStartDate(LocalDate.of(2024, 1, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
        // The number of deposits is 53 weeks, so the amount per deposit is 520 / 53 = 10.00.
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_MonthlyFrequency() {
        // Given
        PeriodicOrderIntent intent =PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(120)); // Total amount
        intent.setFrequency(Frequency.MONTHLY);
        intent.setStartDate(LocalDate.of(2024, 1, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
        // The number of deposits is 12 months, so the amount per deposit is 120 / 12 = 10.00.
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_QuarterlyFrequency() {
        // Given
        PeriodicOrderIntent intent = PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(1020)); // Total amount
        intent.setFrequency(Frequency.QUARTERLY);
        intent.setStartDate(LocalDate.of(2024, 1, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
        // The number of deposits is 4 quarters, so the amount per deposit is 40 / 4 = 10.00.
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_NullAmount() {
        // Given
        PeriodicOrderIntent intent = PeriodicOrderIntent.builder().build();
        intent.setAmount(null);
        intent.setFrequency(Frequency.DAILY);
        intent.setStartDate(LocalDate.of(2024, 1, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_NullStartDate() {
        // Given
        PeriodicOrderIntent intent =PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(3650));
        intent.setFrequency(Frequency.DAILY);
        intent.setStartDate(null); // Start date is null

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.ZERO, result);
    }

    @Test
    void testCalcCurrentYearPeriodicDepositAmount_HalfYearlyFrequency() {
        // Given
        PeriodicOrderIntent intent =PeriodicOrderIntent.builder().build();
        intent.setAmount(BigDecimal.valueOf(20));
        intent.setFrequency(Frequency.HALF_YEARLY);
        intent.setStartDate(LocalDate.of(2024, 7, 1)); // Start date

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(BigDecimal.valueOf(10.00).setScale(2), result);
        // The number of deposits is 2 (half-yearly


    }
}
