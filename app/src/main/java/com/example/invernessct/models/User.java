package com.example.invernessct.models;

import java.io.StringReader;

public class User {

    private int user_id;
    private String email;
    private String first_name;
    private String last_name;
    private String reg_date;
    private String user_type;

    public User(int user_id, String email, String first_name, String last_name, String reg_date, String user_type) {
        this.user_id = user_id;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.reg_date = reg_date;
        this.user_type = user_type;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getReg_date() {
        return reg_date;
    }

    public String getUser_type() { return user_type; }
}
