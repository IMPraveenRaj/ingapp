package com.springheaven.ing.ingapp.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
@lombok.Builder(toBuilder = true)
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor

@JsonTypeName("PeriodicDepositSettings_settings")
public class PeriodicDepositSettingsSettingDTO implements Serializable {

@Valid
@Schema(name="fiscalSettings",requiredMode=Schema.RequiredMode.NOT_REQUIRED)
@JsonProperty("fiscalSettings")
private FiscalSettingsDTO fiscalSettings;
}


