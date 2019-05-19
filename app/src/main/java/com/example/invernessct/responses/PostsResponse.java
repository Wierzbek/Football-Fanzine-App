package com.example.invernessct.responses;

import com.example.invernessct.models.PostsObject;

import java.util.List;

public class PostsResponse {

    private boolean error;
    // Must be the same as JSON table name
    private List<PostsObject> postsTable;

    public PostsResponse(Boolean error, List<PostsObject> postsTable) {
        this.error = error;
        this.postsTable = postsTable;
    }

    public boolean isError() {
        return error;
    }
    public List<PostsObject> getPosts() {
            return postsTable;
    }
}
