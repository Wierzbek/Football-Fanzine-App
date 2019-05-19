package com.example.invernessct.API;

import com.example.invernessct.responses.DefaultResponse;
import com.example.invernessct.responses.FixturesResponse;
import com.example.invernessct.responses.LoginResponse;
import com.example.invernessct.responses.PostsResponse;
import com.example.invernessct.responses.SquadResponse;
import com.example.invernessct.responses.StandingsResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("createuser")
    Call<DefaultResponse> createUser(
            @Field("email") String email,
            @Field("password") String password,
            @Field("first_name") String firstName,
            @Field("last_name") String lastName
    );

    @FormUrlEncoded
    @POST("userlogin")
    Call<LoginResponse> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );

    @GET("getstandings")
    Call<StandingsResponse> getStandings();

    @GET("getfixtures")
    Call<FixturesResponse> getFixtures();

    @GET("getsquad")
    Call<SquadResponse> getSquad();

    @GET("getposts")
    Call<PostsResponse> getPosts();
}
