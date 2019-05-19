package com.example.invernessct.models;

// A model class to store the JSON data of Standings parsed from the database
public class ResultsObject {

    private String results_id, homeShotsonTarget, awayShotsonTarget, homeShotsoffTarget, awayShotsoffTarget, homeOnWoodwork, awayOnWoodwork,
            homeDangerousAttacks, homeCorners, homeFreeKicks, homeGoalKicks, homeThrowIns, homePenaltiesAwarded, homePosesion, awayDangerousAttacks,
            awayCorners, awayFreeKicks, awayGoalKicks, awayThrowIns, awayPenaltiesAwarded, awayPosesion, homeTeamName, awayTeamName, gameDate, gameTime;

    public ResultsObject(String results_id, String homeShotsonTarget, String awayShotsonTarget, String homeShotsoffTarget, String awayShotsoffTarget, String homeOnWoodwork, String awayOnWoodwork, String homeDangerousAttacks, String homeCorners, String homeFreeKicks, String homeGoalKicks, String homeThrowIns, String homePenaltiesAwarded, String homePosesion, String awayDangerousAttacks, String awayCorners, String awayFreeKicks, String awayGoalKicks, String awayThrowIns, String awayPenaltiesAwarded, String awayPosesion, String homeTeamName, String awayTeamName, String gameDate, String gameTime) {
        this.results_id = results_id;
        this.homeShotsonTarget = homeShotsonTarget;
        this.awayShotsonTarget = awayShotsonTarget;
        this.homeShotsoffTarget = homeShotsoffTarget;
        this.awayShotsoffTarget = awayShotsoffTarget;
        this.homeOnWoodwork = homeOnWoodwork;
        this.awayOnWoodwork = awayOnWoodwork;
        this.homeDangerousAttacks = homeDangerousAttacks;
        this.homeCorners = homeCorners;
        this.homeFreeKicks = homeFreeKicks;
        this.homeGoalKicks = homeGoalKicks;
        this.homeThrowIns = homeThrowIns;
        this.homePenaltiesAwarded = homePenaltiesAwarded;
        this.homePosesion = homePosesion;
        this.awayDangerousAttacks = awayDangerousAttacks;
        this.awayCorners = awayCorners;
        this.awayFreeKicks = awayFreeKicks;
        this.awayGoalKicks = awayGoalKicks;
        this.awayThrowIns = awayThrowIns;
        this.awayPenaltiesAwarded = awayPenaltiesAwarded;
        this.awayPosesion = awayPosesion;
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.gameDate = gameDate;
        this.gameTime = gameTime;
    }

    public String getResults_id() {
        return results_id;
    }

    public String getHomeShotsonTarget() {
        return homeShotsonTarget;
    }

    public String getAwayShotsonTarget() {
        return awayShotsonTarget;
    }

    public String getHomeShotsoffTarget() {
        return homeShotsoffTarget;
    }

    public String getAwayShotsoffTarget() {
        return awayShotsoffTarget;
    }

    public String getHomeOnWoodwork() {
        return homeOnWoodwork;
    }

    public String getAwayOnWoodwork() {
        return awayOnWoodwork;
    }

    public String getHomeDangerousAttacks() {
        return homeDangerousAttacks;
    }

    public String getHomeCorners() {
        return homeCorners;
    }

    public String getHomeFreeKicks() {
        return homeFreeKicks;
    }

    public String getHomeGoalKicks() {
        return homeGoalKicks;
    }

    public String getHomeThrowIns() {
        return homeThrowIns;
    }

    public String getHomePenaltiesAwarded() {
        return homePenaltiesAwarded;
    }

    public String getHomePosesion() {
        return homePosesion;
    }

    public String getAwayDangerousAttacks() {
        return awayDangerousAttacks;
    }

    public String getAwayCorners() {
        return awayCorners;
    }

    public String getAwayFreeKicks() {
        return awayFreeKicks;
    }

    public String getAwayGoalKicks() {
        return awayGoalKicks;
    }

    public String getAwayThrowIns() {
        return awayThrowIns;
    }

    public String getAwayPenaltiesAwarded() {
        return awayPenaltiesAwarded;
    }

    public String getAwayPosesion() {
        return awayPosesion;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public String getGameDate() {
        return gameDate;
    }

    public String getGameTime() {
        return gameTime;
    }
}
