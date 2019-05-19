package com.example.invernessct.models;

// A model class to store the JSON data of Standings parsed from the database
public class PostsObject {

    private String post_id, post_author, post_title, post_content, post_category, post_status, post_image, post_tags, post_date;

    public PostsObject(String post_id, String post_author, String post_title, String post_content, String post_category, String post_status, String post_image, String post_tags, String post_date) {
        this.post_id = post_id;
        this.post_author = post_author;
        this.post_title = post_title;
        this.post_content = post_content;
        this.post_category = post_category;
        this.post_status = post_status;
        this.post_image = post_image;
        this.post_tags = post_tags;
        this.post_date = post_date;
    }

    public String getPost_id() {
        return post_id;
    }

    public String getPost_author() {
        return post_author;
    }

    public String getPost_title() {
        return post_title;
    }

    public String getPost_content() {
        return post_content;
    }

    public String getPost_category() {
        return post_category;
    }

    public String getPost_status() {
        return post_status;
    }

    public String getPost_image() {
        return post_image;
    }

    public String getPost_tags() {
        return post_tags;
    }

    public String getPost_date() {
        return post_date;
    }
}