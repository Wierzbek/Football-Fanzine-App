package com.example.invernessct.models;

// A model class to store the JSON data of Standings parsed from the database
public class SquadObject {

    private String player_name, player_number, player_dob, place_of_birth, age, player,height, citizenship, player_position, foot, joined, contract_until, image;

    public SquadObject(String player_name, String player_number, String player_dob, String place_of_birth, String age, String player, String height, String citizenship, String player_position, String foot, String joined, String contract_until, String image) {
        this.player_name = player_name;
        this.player_number = player_number;
        this.player_dob = player_dob;
        this.place_of_birth = place_of_birth;
        this.age = age;
        this.player = player;
        this.height = height;
        this.citizenship = citizenship;
        this.player_position = player_position;
        this.foot = foot;
        this.joined = joined;
        this.contract_until = contract_until;
        this.image=image;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public String getPlayer_number() {
        return player_number;
    }

    public String getPlayer_dob() {
        return player_dob;
    }

    public String getPlace_of_birth() {
        return place_of_birth;
    }

    public String getAge() {
        return age;
    }

    public String getPlayer() {
        return player;
    }

    public String getHeight() {
        return height;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public String getPlayer_position() {
        return player_position;
    }

    public String getFoot() {
        return foot;
    }

    public String getJoined() {
        return joined;
    }

    public String getContract_until() {
        return contract_until;
    }

    public String getImage() {
        return image;
    }
}
