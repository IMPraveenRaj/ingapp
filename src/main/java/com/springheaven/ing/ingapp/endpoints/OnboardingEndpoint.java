package com.springheaven.ing.ingapp.endpoints;

import com.springheaven.ing.ingapp.responses.FrequencyDTO;
import com.springheaven.ing.ingapp.responses.NoPeriodicDeposit;
import com.springheaven.ing.ingapp.responses.PeriodicDepositResponseDto;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class OnboardingEndpoint implements OnboardingEndPointApi{
    @Override
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetail() {

        val noPeriodicDeposit = NoPeriodicDeposit.builder().amount(BigDecimal.valueOf(1020)).
                   indexed(true).
                build();


        return ResponseEntity.ok(PeriodicDepositResponseDto.builder().
                amount(BigDecimal.valueOf(1000)).indexed(false).frequency(FrequencyDTO.valueOf("QUARTERLY"))
                        .noPeriodicDeposit(noPeriodicDeposit)
                .build());


    }
}
