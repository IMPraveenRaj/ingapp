package com.springheaven.ing.ingapp;

import com.springheaven.ing.ingapp.model.Frequency;
import lombok.val;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sound.midi.SysexMessage;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;
import java.util.List;
import java.util.function.Predicate;


public class MainApp {


    private static long calculateNumberOfDeposits(Frequency frequency, LocalDate startDate) {

        val endDate= LocalDate.of(startDate.getYear(), 12,31);
        switch (frequency) {
            case DAILY:
                return ChronoUnit.DAYS.between(startDate, endDate)+1;
            case WEEKLY:
                return ChronoUnit.WEEKS.between(startDate, endDate)+1;
            case MONTHLY:
                return ChronoUnit.MONTHS.between(startDate, endDate)+1;
            case QUARTERLY:
                return IsoFields.QUARTER_YEARS.between(startDate, endDate)+1;
            case HALF_YEARLY:
                return startDate.getMonthValue()>6 ?2 :1;
            default:
                return 1;

        }

    }

    public static void main(String[] args) {


        LocalDate startDate = LocalDate.of(2020, 6, 1);
        val endDate = LocalDate.of(startDate.getYear(), 12, 31);
        long Monthsbetween = IsoFields.QUARTER_YEARS.between(startDate, endDate)+1;
        System.out.println(Monthsbetween);
        long Days = calculateNumberOfDeposits(Frequency.QUARTERLY, startDate);
        System.out.println(Days);

        List<String> names= List.of("praveenraj");
        Predicate<String> praveenraj1 = name -> name.equals("praveenraj");
        long praveenraj = names.stream().filter(praveenraj1).count();
        System.out.println(praveenraj);


    }

}
