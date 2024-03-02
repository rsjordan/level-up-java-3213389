package com.linkedin.javacodechallenges;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Team {
  private final String player1;
  private final String player2;
  private final List<Integer> scores;

  public Team(String player1, String player2) {
    this.player1 = player1;
    this.player2 = player2;
    scores = new ArrayList<>();
  }

  public int sumTotalScore() {
    return scores.stream().filter(score -> score > 0)
        .reduce(Integer::sum).orElse(0);
  }

  public String getPlayerNames() {
    return player1 + "/" + player2;
  }

  public int compareTo(Team anotherTeam) {
    int scoreDiff = this.sumTotalScore() - anotherTeam.sumTotalScore();
    if (scoreDiff > 0) {
      return 1;
    } else if (scoreDiff < 0) {
      return -1;
    } else {
      return 0;
    }
  }
  
  public int reverseCompareTo(Team anotherTeam) {
    int scoreDiff = this.sumTotalScore() - anotherTeam.sumTotalScore();
    if (scoreDiff > 0) {
      return -1;
    } else if (scoreDiff < 0) {
      return 1;
    } else {
      return 0;
    }
  }
}