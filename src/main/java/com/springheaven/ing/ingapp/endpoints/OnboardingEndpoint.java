package com.springheaven.ing.ingapp.endpoints;

import com.springheaven.ing.ingapp.responses.FrequencyDTO;
import com.springheaven.ing.ingapp.responses.PeriodicDepositResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class OnboardingEndpoint implements OnboardingEndPointApi{
    @Override
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetail() {

        return ResponseEntity.ok(PeriodicDepositResponseDto.builder().
                amount(BigDecimal.valueOf(1000)).indexed(false).frequency(FrequencyDTO.valueOf("QUARTERLY"))
                .build());


    }
}
