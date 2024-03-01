package com.linkedin.javacodechallenges;

import java.time.LocalDate;
import java.time.ZoneId;

public class App 
{
    // Create function to calculate the date that's 
    // 100 days from now
    public static LocalDate calculateHundredDaysFromNow(LocalDate today) {
        return today.plusDays(100);
    }

    public static void main( String[] args )
    {
        System.out.println("Now is... "
            + LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST"))));
        System.out.println("100 days from now is... " 
            + calculateHundredDaysFromNow(LocalDate.now(ZoneId.of(ZoneId.SHORT_IDS.get("PST")))));
    }
}
