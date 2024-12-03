package com.springheaven.ing.ingapp.responses;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum FrequencyDTO {


    MONTHLY("MONTHLY"),
    QUARTERLY("QUARTERLY"),
    YEARLY("YEARLY"),
    HALF_YEARLY("HALF_YEARLY")
    ,NONE("NONE");


    private String value;
    FrequencyDTO(String value){
        this.value=value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }

    @Override
    public String toString() { return String.valueOf(value); }

    @JsonCreator
    public static FrequencyDTO fromValue(String value){
        for (FrequencyDTO b : FrequencyDTO.values()){
            if(b.getValue().equals(value)){
                return b;
            }
        }
        throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
}
