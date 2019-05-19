package com.example.invernessct.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.invernessct.R;
import com.example.invernessct.models.FixturesObject;

import java.util.List;

public class FixturesAdapter extends RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder> {

    private Context mContext;
    // Objects to display
    private List<FixturesObject> fixturesList;


    public FixturesAdapter(Context mContext, List<FixturesObject> fixturesObjects) {
        this.mContext = mContext;
        this.fixturesList = fixturesObjects;
    }

    @NonNull
    @Override
    public FixturesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_fixtures, viewGroup, false);
        return new FixturesViewHolder(view);
    }


    // Send the data to the text views in recyclerview_fixtures
    @Override
    public void onBindViewHolder(@NonNull FixturesViewHolder holder, int position) {
        FixturesObject fixturesObject = fixturesList.get(position);

        holder.textViewHomeTeam.setText(fixturesObject.getHome_team());
        holder.textViewAwayTeam.setText(fixturesObject.getAway_team());
        holder.textViewDate.setText(fixturesObject.getGame_date());
        holder.textViewTime.setText(fixturesObject.getGame_time());
        holder.textViewStadium.setText(fixturesObject.getStadium());
    }


    @Override
    public int getItemCount() {
        return fixturesList.size();
    }

    class FixturesViewHolder extends RecyclerView.ViewHolder{
        TextView textViewHomeTeam, textViewAwayTeam, textViewDate, textViewTime, textViewStadium;

        public FixturesViewHolder (View itemView){
            super(itemView);

            textViewHomeTeam = itemView.findViewById(R.id.textViewHomeTeam);
            textViewAwayTeam = itemView.findViewById(R.id.textViewAwayTeam);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewTime = itemView.findViewById(R.id.textViewTime);
            textViewStadium = itemView.findViewById(R.id.textViewStadium);
        }
    }
}


