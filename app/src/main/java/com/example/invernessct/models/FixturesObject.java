package com.example.invernessct.models;

public class FixturesObject {

        private String home_team, away_team, game_date, game_time, stadium;

    public FixturesObject(String home_team, String away_team, String game_date, String game_time, String stadium) {
        this.home_team = home_team;
        this.away_team = away_team;
        this.game_date = game_date;
        this.game_time = game_time;
        this.stadium = stadium;
    }

    public String getHome_team() {
        return home_team;
    }

    public String getAway_team() {
        return away_team;
    }

    public String getGame_date() {
        return game_date;
    }

    public String getGame_time() {
        return game_time;
    }

    public String getStadium() {
        return stadium;
    }
}
