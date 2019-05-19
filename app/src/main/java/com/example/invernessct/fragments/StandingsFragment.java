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
import com.example.invernessct.adapters.StandingsAdapter;
import com.example.invernessct.responses.StandingsResponse;
import com.example.invernessct.models.StandingsTableObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StandingsFragment extends Fragment {

    private RecyclerView recyclerView;
    private StandingsAdapter adapter;
    private List<StandingsTableObject> standingsTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_standings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewStandings);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Get the fixtures list of standings objects
        Call<StandingsResponse> call = RetrofitClient.getInstance().getApi().getStandings();

        // Call
        call.enqueue(new Callback<StandingsResponse>() {
            @Override
            public void onResponse(Call<StandingsResponse> call, Response<StandingsResponse> response) {

                // The fixtures list
                standingsTable = response.body().getStandings();

                //
                adapter = new StandingsAdapter(getActivity(), standingsTable);

                //
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<StandingsResponse> call, Throwable t) {

            }
        });
    }
}
