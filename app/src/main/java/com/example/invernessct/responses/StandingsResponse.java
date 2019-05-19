package com.example.invernessct.responses;

import com.example.invernessct.models.StandingsTableObject;

import java.util.List;

public class StandingsResponse {

    private boolean error;
    private List<StandingsTableObject> standingsTable;

    public StandingsResponse(Boolean error, List<StandingsTableObject> standingsObjects) {
        this.error = error;
        this.standingsTable = standingsObjects;
    }

    public boolean isError() {
        return error;
    }
    public List<StandingsTableObject> getStandings() {
        return standingsTable;
    }

}
