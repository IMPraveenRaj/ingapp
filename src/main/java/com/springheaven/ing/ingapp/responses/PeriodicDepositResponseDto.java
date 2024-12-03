package com.springheaven.ing.ingapp.responses;




import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@lombok.Builder(toBuilder = true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
@JsonTypeName("PeriodicDepositResponse")
public class PeriodicDepositResponseDto implements Serializable {

    private static final long serialVersionUID = 1L;

     private String currency;

    private BigDecimal amount;

    private FrequencyDTO frequency;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate statDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate endDate;

    private Boolean indexed;

   // private FunctionalErrorResultDTO functionalErrorResultDTO;
    private PeriodicDepositSettingsSettingDTO settings;


    @Valid
    @Schema(name="noPeriodicDeposit",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("noPeriodicOrder")
    public NoPeriodicDeposit getNoPeriodicDeposit() {
        return noPeriodicDeposit;
    }

    public void setNoPeriodicDeposit(NoPeriodicDeposit noPeriodicDeposit) {
        this.noPeriodicDeposit = noPeriodicDeposit;
    }

    private NoPeriodicDeposit noPeriodicDeposit;


    public Boolean isIndexed() {
        return indexed;
    }

    public void setIndexed(Boolean indexed) {
        this.indexed = indexed;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Valid
    @Schema(name="currency",example = "EUR",description = "currency used for initial deposit", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("currency")
    public String getCurrency() {  return this.currency; }


    @Valid
    @Schema(name="amount",example = "500.00",description = "periodic amount to deposit",requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonProperty("amounts")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {this.amount=amount;}



    public void setStatDate(LocalDate statDate) { this.statDate = statDate;      }

    public LocalDate getStatDate() {return this.statDate;}

    public void setEndDate(LocalDate endDate) { this.endDate = endDate;}
    public LocalDate getEndDate() {return this.endDate;}

    @Valid
    @Schema(name="frequency",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("frequency")
    public FrequencyDTO getFrequency() {
        return frequency;
    }

    public void setFrequency(FrequencyDTO frequency) {
        this.frequency = frequency;
    }


    @Valid
    @Schema(name="settings",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("settings")
    public PeriodicDepositSettingsSettingDTO getSettings() {
        return settings;
    }

    public void setSettings(PeriodicDepositSettingsSettingDTO settings) {
        this.settings = settings;
    }
}
