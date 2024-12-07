package com.springheaven.ing.ingapp.endpoints;

import com.springheaven.ing.ingapp.responses.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.UUID;

@Controller
@Slf4j
@RequiredArgsConstructor
public class OnboardingEndpoint implements OnboardingEndPointApi{

    private final ExecutionHelper helper;

    private final OnboardingService onboardingService;


    @Override
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetail() {






        val settings= PeriodicDepositSettingsSettingDTO.builder().fiscalSettings(FiscalSettingsDTO.builder().
                build()).build();
        val noPeriodicDeposit = NoPeriodicDeposit.builder().amount(BigDecimal.valueOf(1020)).
                indexed(true).
                build();


        return ResponseEntity.ok(PeriodicDepositResponseDto.builder().
                settings(settings).
                amount(BigDecimal.valueOf(1000)).indexed(false).frequency(FrequencyDTO.valueOf("QUARTERLY"))
                        .noPeriodicDeposit(noPeriodicDeposit)
                .build());


    }

    @Override
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetailwithhelper() {
        return helper.execute(UUID.randomUUID(),(user,process) -> ResponseEntity.ok(
                //PeriodicDepositResponseDto.builder().build()));
                onboardingService.getPeriodicDepositWithDetails(user,process).map( deposit ->{

                    val details = "Details";
                    val fiscalCeilingzeroError= "PERIODIC_ORDER_REVISION".equals("PERIODIC_ORDER_REVISION1") &&
                            "BE_STAR_FUND".equals("BE_STAR_FUND1");
                    val functionalErrorResultDTO = fiscalCeilingzeroError ? FunctionalErrorResultDTO.builder().build(): null;
                    val settings= PeriodicDepositSettingsSettingDTO.builder().fiscalSettings(FiscalSettingsDTO.builder().
                            build()).build();
                    val noPeriodicDeposit = NoPeriodicDeposit.builder().amount(BigDecimal.valueOf(1020)).
                            indexed(true).
                            build();
                    return PeriodicDepositResponseDto.builder().
                            settings(settings).
                            amount(BigDecimal.valueOf(1000)).indexed(false).frequency(FrequencyDTO.valueOf("QUARTERLY"))
                            .noPeriodicDeposit(noPeriodicDeposit)
                            .build();
                        }).orElse(PeriodicDepositResponseDto.builder().build())));


    }
}
