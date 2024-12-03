package com.springheaven.ing.ingapp.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Builder(toBuilder = true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("PeriodicDepositSettings_settings")
public class PeriodicDepositSettingsSettingDTO implements Serializable {

    private static final long serialVersionUID = 1L;


    private FiscalSettingsDTO fiscalSettings;

    private Boolean customerAgeBelowThreshold;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate minStartDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate maxStartDate;


    private BigDecimal minimumAmount;

    private BigDecimal maximumAmount;

    @Valid
    private List<FrequencyDTO> allowedFrequencies = new ArrayList<>();

    private FrequencyDTO allowedFrequencyToCancelOrder;


    @Valid
    @Schema(name="fiscalSettings",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("fiscalSettings")
    public FiscalSettingsDTO getFiscalSettings() {
        return fiscalSettings;
    }

    public void setFiscalSettings(FiscalSettingsDTO fiscalSettings) {
        this.fiscalSettings = fiscalSettings;
    }



    @Schema(name="customerAgeBelowThreshold",description = "This field is true if the customer's Age is below the configured threshold in somecase this piece of information is needed ",
            requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("customerAgeBelowThreshold")
    public Boolean isCustomerAgeBelowThreshold() { return customerAgeBelowThreshold; }


    @Valid
    @Schema(name="minStartDate",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("minStartDate")
    public LocalDate getMinStartDate() {return minStartDate;}

    public void setMinStartDate(LocalDate minStartDate) { this.minStartDate = minStartDate;}

    @Valid
    @Schema(name="maxStartDate",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("maxStartDate")
    public LocalDate getMaxStartDate() {return maxStartDate;}

    public void setMaxStartDate(LocalDate maxStartDate) { this.maxStartDate = maxStartDate;}


    @Valid
    @Schema(name="minimumAmount",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("minimumAmount")
    public BigDecimal getMinimumAmount() {return minimumAmount;}
    public void setMinimumAmount(BigDecimal minimumAmount) {
        this.minimumAmount = minimumAmount;
    }

    @Valid
    @Schema(name="maximumAmount",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("maximumAmount")
    public BigDecimal getMaximumAmount() {return maximumAmount;}


    public void setMaximumAmount(BigDecimal maximumAmount) { this.maximumAmount = maximumAmount;}

    @Valid
    @JsonProperty("allowedFrequencies")
    @Schema(name = "allowedFrequencies",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public List<FrequencyDTO> getAllowedFrequencies() {return allowedFrequencies;}

    public void setAllowedFrequencies(List<FrequencyDTO> allowedFrequencies) {this.allowedFrequencies = allowedFrequencies;}


    @Valid
    @JsonProperty("allowedFrequencyToCancelOrder")
    @Schema(name = "allowedFrequencyToCancelOrder",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    public FrequencyDTO getAllowedFrequencyToCancelOrder() {
        return allowedFrequencyToCancelOrder;
    }

    public void setAllowedFrequencyToCancelOrder(FrequencyDTO allowedFrequencyToCancelOrder) { this.allowedFrequencyToCancelOrder = allowedFrequencyToCancelOrder;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodicDepositSettingsSettingDTO periodicDepositSettingsSettings = (PeriodicDepositSettingsSettingDTO) o;
        return Objects.equals(this.fiscalSettings,periodicDepositSettingsSettings.fiscalSettings) &&
        Objects.equals(this.customerAgeBelowThreshold,periodicDepositSettingsSettings.customerAgeBelowThreshold);


    }
}


