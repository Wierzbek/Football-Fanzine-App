package com.example.invernessct.responses;

import com.example.invernessct.models.SquadObject;

import java.util.List;

public class SquadResponse {

    private boolean error;
    private List<SquadObject> squadTable;

    public SquadResponse(Boolean error, List<SquadObject> squadObjects) {
        this.error = error;
        this.squadTable = squadObjects;
    }

    public boolean isError() {
        return error;
    }
    public List<SquadObject> getSquads() {
        return squadTable;
    }

}
