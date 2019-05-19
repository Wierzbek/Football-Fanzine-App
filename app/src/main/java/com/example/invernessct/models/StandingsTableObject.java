package com.example.invernessct.models;

// A model class to store the JSON data of Standings parsed from the database
public class StandingsTableObject {

    private String club_name, games_played, wins, drawn, lost, goals_for, goals_against, goal_difference, points;

    public StandingsTableObject(String club_name, String games_played, String wins, String drawn, String lost, String goals_for, String goals_against, String goal_difference, String points) {
        this.club_name = club_name;
        this.games_played = games_played;
        this.wins = wins;
        this.drawn = drawn;
        this.lost = lost;
        this.goals_for = goals_for;
        this.goals_against = goals_against;
        this.goal_difference = goal_difference;
        this.points = points;
    }

    public String getClub_name() {
        return club_name;
    }

    public String getGames_played() {
        return games_played;
    }

    public String getWins() {
        return wins;
    }

    public String getDrawn() {
        return drawn;
    }

    public String getLost() {
        return lost;
    }

    public String getGoals_for() {
        return goals_for;
    }

    public String getGoals_against() {
        return goals_against;
    }

    public String getGoal_difference() {
        return goal_difference;
    }

    public String getPoints() {
        return points;
    }
}
