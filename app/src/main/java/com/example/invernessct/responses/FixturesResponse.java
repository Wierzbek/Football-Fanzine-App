package com.example.invernessct.responses;

import com.example.invernessct.models.FixturesObject;

import java.util.List;

public class FixturesResponse {

    private boolean error;
    private List<FixturesObject> fixturesTable;

    public FixturesResponse(boolean error, List<FixturesObject> fixturesTable) {
        this.fixturesTable = fixturesTable;
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public List<FixturesObject> getFixtures() {
        return fixturesTable;
    }

}
