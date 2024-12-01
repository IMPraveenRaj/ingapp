package com.springheaven.ing.ingapp.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Getter
@Setter
@Builder
public class PeriodicOrderIntent {



    private BigDecimal amount;

    private Frequency Frequency;

    private LocalDate startDate;

}
