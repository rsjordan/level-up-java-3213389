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
        // System.out.println("RSJ DEBUG - INPUT students: " + students);
        // System.out.println("RSJ DEBUG - INPUT attendeesMapping: " + attendeesMapping);

        List<String> studentsWithIncompleteVolunteerEvents = new ArrayList<>();

        Map<String, Integer> nameToCountMap = new HashMap<>();
        for (List<String> value : attendeesMapping.values()) {
            value.stream().forEach(name -> {
                if (!nameToCountMap.containsKey(name)) {
                    nameToCountMap.put(name, 1);
                } else {
                    nameToCountMap.put(name, nameToCountMap.get(name) + 1);
                }
            });
        }
        // System.out.println("RSJ DEBUG - nameToCountMap: " + nameToCountMap);

        for (String student : students) {
            if (!nameToCountMap.containsKey(student) || (nameToCountMap.get(student) < COMPLETE_MINIMUM)) {
                studentsWithIncompleteVolunteerEvents.add(student);
            }
        }
        
        // System.out.println("RSJ DEBUG - studentsWithIncompleteVolunteerEvents: " + studentsWithIncompleteVolunteerEvents);
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
