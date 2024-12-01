package com.springheaven.ing.ingapp.helper;


import com.springheaven.ing.ingapp.model.Frequency;
import com.springheaven.ing.ingapp.model.PeriodicOrderIntent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PeriodicDepositHelperTestParameterized {


    PeriodicDepositHelper  periodicDepositHelper;

    private PeriodicOrderIntent createOrder(BigDecimal amount, Frequency frequency, LocalDate startDate) {
        PeriodicOrderIntent intent = new PeriodicOrderIntent();
        intent.setAmount(amount);
        intent.setFrequency(frequency);
        intent.setStartDate(startDate);
        return intent;
    }

    @BeforeEach
    void setUp() {
        periodicDepositHelper= new PeriodicDepositHelper();
    }

    @ParameterizedTest
    @CsvSource({
            "1020, DAILY, 2023-01-01, 2.79",
            "1020, WEEKLY, 2023-01-01, 19.25",
            "1020, MONTHLY, 2023-01-01, 85",
            "1020, QUARTERLY, 2023-01-01, 255",
            "1020, YEARLY, 2023-01-01, 1020",
    })
    void testCalcCurrentYearPeriodicDepositAmount(BigDecimal amount, Frequency frequency, String startDate, BigDecimal expected) {
        // Given
        PeriodicOrderIntent intent = createOrder(amount, frequency, LocalDate.parse(startDate));

        // When
        BigDecimal result = periodicDepositHelper.calcCurrentYearPeriodicDepositAmount(intent);

        // Then
        assertEquals(expected.setScale(2), result);
    }

}
