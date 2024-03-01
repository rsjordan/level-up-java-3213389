package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static List<String> findStudentsWithIncompleteVolunteerEvents(
            List<String> students,
            Map<String, List<String>> attendeesMapping) {
                
        int COMPLETE_MINIMUM = 2;

        List<String> studentsWithIncompleteVolunteerEvents = new ArrayList<>();

        Map<String, Integer> studentsEventCount = new HashMap<>();
        for (List<String> value : attendeesMapping.values()) {
            value.stream().forEach(name -> {
                if (!studentsEventCount.containsKey(name)) {
                    studentsEventCount.put(name, 1);
                } else {
                    studentsEventCount.put(name, studentsEventCount.get(name) + 1);
                }
            });
        }

        for (String student : students) {
            if (!studentsEventCount.containsKey(student) || (studentsEventCount.get(student) < COMPLETE_MINIMUM)) {
                studentsWithIncompleteVolunteerEvents.add(student);
            }
        }
        
        return studentsWithIncompleteVolunteerEvents;
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly",
                "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));

        List<String> studentSet1 = List.of("Sally", "Polly", "Molly", "Tony", "Harry");
        Map<String, List<String>> attendeesMapping1 = Map.of("Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));
        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                studentSet1, attendeesMapping1));
    }

}
