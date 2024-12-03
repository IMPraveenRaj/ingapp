package com.springheaven.ing.ingapp.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.math.BigDecimal;

@lombok.Builder(toBuilder = true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonTypeName("NoPeriodicDepositResponse")
public class NoPeriodicDeposit {

    private BigDecimal amount;

    private Boolean indexed;

    @Valid
    @JsonProperty("amount")
    @Schema(name = "amount",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Valid
    @Schema(name = "indexed", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("indexed")
    public Boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(Boolean indexed) {
        this.indexed = indexed;
    }
}
