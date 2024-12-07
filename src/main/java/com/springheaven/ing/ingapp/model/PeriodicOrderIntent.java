package com.springheaven.ing.ingapp.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString(callSuper = true)
public class PeriodicOrderIntent {



    private BigDecimal amount;

    private Frequency Frequency;

    private LocalDate startDate;

}
