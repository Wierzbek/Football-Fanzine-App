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
import com.example.invernessct.adapters.SquadAdapter;
import com.example.invernessct.models.SquadObject;
import com.example.invernessct.responses.SquadResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SquadFragment extends Fragment {

    private RecyclerView recyclerView;
    private SquadAdapter adapter;
    private List<SquadObject> squadTable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_squad, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerViewSquad);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Get the squad list of objects (squadObject)
        Call<SquadResponse> call = RetrofitClient.getInstance().getApi().getSquad();

        // Call
        call.enqueue(new Callback<SquadResponse>() {
            @Override
            public void onResponse(Call<SquadResponse> call, Response<SquadResponse> response) {

                // The squad list
                squadTable = response.body().getSquads();

                // Bind the data with the xml views
                adapter = new SquadAdapter(getActivity(), squadTable);

                // Present the view list in the recycler view
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<SquadResponse> call, Throwable t) {

            }
        });
    }
}
