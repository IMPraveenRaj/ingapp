package com.springheaven.ing.ingapp.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.io.Serializable;
import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Builder(toBuilder = true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("FiscalSettings")
public class FiscalSettingsDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private BigDecimal legalHighAmount;

    private BigDecimal legalHighPercentage;

    private BigDecimal legalLowAmount;

    private BigDecimal legalLowPercentage;


    @Valid
    @Schema(name="legalHighAmount",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("legalHighAmount")
    public BigDecimal getLegalHighAmount() { return legalHighAmount;}

    public void setLegalHighAmount(BigDecimal legalHighAmount) { this.legalHighAmount = legalHighAmount;}


    @Valid
    @Schema(name = "legalLowAmount",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("legalLowAmount")
    public BigDecimal getLegalLowAmount() {
        return legalLowAmount;
    }
    public void setLegalLowAmount(BigDecimal legalLowAmount) {this.legalLowAmount = legalLowAmount;}


    @Valid
    @Schema(name = "legalHighPercentage",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("legalHighPercentage")
    public BigDecimal getLegalHighPercentage() {
        return legalHighPercentage;
    }


    public void setLegalHighPercentage(BigDecimal legalHighPercentage) {this.legalHighPercentage = legalHighPercentage;}

    @Valid
    @Schema(name = "legalLowPercentage",requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("legalLowPercentage")
    public BigDecimal getLegalLowPercentage() {
        return legalLowPercentage;
    }

    public void setLegalLowPercentage(BigDecimal legalLowPercentage) {this.legalLowPercentage = legalLowPercentage;}
}
