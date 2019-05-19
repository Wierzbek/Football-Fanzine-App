package com.example.invernessct.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.invernessct.API.RetrofitClient;
import com.example.invernessct.R;
import com.example.invernessct.adapters.PostsAdapter;
import com.example.invernessct.models.PostsObject;
import com.example.invernessct.responses.PostsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostsFragment extends Fragment {

    private RecyclerView recyclerView;
    private PostsAdapter adapter;
    private List<PostsObject> postsTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewPosts);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Get the posts list of objects (postObject)
        // Call to the Api file in API "getPosts()"
        Call<PostsResponse> call = RetrofitClient.getInstance().getApi().getPosts();

        // Call
        call.enqueue(new Callback<PostsResponse>() {
            @Override
            public void onResponse(Call<PostsResponse> call, Response<PostsResponse> response) {

                // The squad list
                postsTable = response.body().getPosts();

                //
                adapter = new PostsAdapter(getActivity(), postsTable);

                //
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PostsResponse> call, Throwable t) {

            }
        });
    }
}
