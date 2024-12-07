package com.springheaven.ing.ingapp.endpoints;

import com.springheaven.ing.ingapp.model.PeriodicOrderIntent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class OnboardingService {




    public Optional<PeriodicOrderIntent> getPeriodicDepositWithDetails(String user, String process){

        val periodicOderIntent=PeriodicOrderIntent.builder().build();
        return Optional.ofNullable(periodicOderIntent);
    }

}
