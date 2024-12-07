package com.springheaven.ing.ingapp.endpoints;

import com.springheaven.ing.ingapp.responses.PeriodicDepositResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface OnboardingEndPointApi {

    @RequestMapping(
            method = RequestMethod.GET,
            value="/investment/onboarding/periodic-deposit",
            produces = {"application/json"}

    )
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetail();



    @RequestMapping(
            method = RequestMethod.GET,
            value="/investment/onboarding/periodic-deposit-helper",
            produces = {"application/json"}

    )
    public ResponseEntity<PeriodicDepositResponseDto> getPeriodicDepositDetailwithhelper();
}
