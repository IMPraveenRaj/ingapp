package com.springheaven.ing.ingapp.endpoints;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExecutionHelper {

    public <R> R execute(UUID processID, BiFunction<String ,String ,R> function) {

        return execute(true,processID,function);

    }

    public <R> R execute(boolean b, UUID processID, BiFunction<String, String,R> function) {
        val user= "user";
        val process ="process";
        return function.apply(user,process);
    }
}
