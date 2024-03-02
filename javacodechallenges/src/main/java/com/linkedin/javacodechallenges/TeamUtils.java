package com.linkedin.javacodechallenges;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TeamUtils {

  public static void generateTeamsScores(List<Team> teams,
      int numberOfRounds) {
    Random random = new Random();
    teams.forEach(team -> {
      for (int i = 0; i < numberOfRounds; i++) {
        team.getScores().add(random.nextInt(11));
      }
    });
  }

  public static void revealResults(List<Team> teams) {
    if (teams == null || teams.isEmpty()) {
      System.out.println("No valid teams were provided.");
      return;
    }

    List<Team> sortedTeams = teams.stream()
      .sorted(Team::reverseCompareTo)
      .collect(Collectors.toList());

    System.out.println("The winner is team " + sortedTeams.get(0).getPlayerNames() + "!");
    System.out.println("Complete results: ");
    sortedTeams.stream()
      .forEach(t -> System.out.println("  " + t.getPlayerNames() + "\ttotal score: " + t.sumTotalScore()));
  }
}