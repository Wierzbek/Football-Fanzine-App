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
import com.example.invernessct.adapters.FixturesAdapter;
import com.example.invernessct.models.FixturesObject;
import com.example.invernessct.responses.FixturesResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FixturesFragment extends Fragment {

    private RecyclerView recyclerView;
    private FixturesAdapter adapter;
    private List<FixturesObject> fixturesTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fixtures, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewFixtures);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Get the fixtures list of fixtures
        Call<FixturesResponse> call = RetrofitClient.getInstance().getApi().getFixtures();

        // Call
        call.enqueue(new Callback<FixturesResponse>() {
            @Override
            public void onResponse(Call<FixturesResponse> call, Response<FixturesResponse> response) {

                // The fixtures list
                fixturesTable = response.body().getFixtures();

                //
                adapter = new FixturesAdapter(getActivity(), fixturesTable);

                //
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<FixturesResponse> call, Throwable t) {

            }
        });
    }
}
