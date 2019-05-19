package com.example.invernessct.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.invernessct.R;
import com.example.invernessct.models.StandingsTableObject;

import java.util.List;

public class StandingsAdapter extends RecyclerView.Adapter<StandingsAdapter.StandingsViewHolder> {

    // Context object
    private Context mContext;
    // List of standings objects
    private List<StandingsTableObject> standingsList;

    public StandingsAdapter(Context mContext, List<StandingsTableObject> standingsList) {
        this.mContext = mContext;
        this.standingsList = standingsList;
    }

    @NonNull
    @Override
    public StandingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_standings, viewGroup, false);
        return new StandingsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StandingsViewHolder holder,int position) {
        StandingsTableObject standingsObject = standingsList.get(position);

        holder.textViewTeam.setText((position + 1) + ". " + standingsObject.getClub_name());
        holder.textViewGP.setText(standingsObject.getGames_played());
        holder.textViewWins.setText(standingsObject.getWins());
        holder.textViewDrawn.setText(standingsObject.getDrawn());
        holder.textViewLost.setText(standingsObject.getLost());
        holder.textViewGF.setText(standingsObject.getGoals_for());
        holder.textViewGA.setText(standingsObject.getGoals_against());
        holder.textViewGD.setText(standingsObject.getGoal_difference());
        holder.textViewPts.setText(standingsObject.getPoints());
    }

    @Override
    public int getItemCount() {
        return standingsList.size();
    }

    class StandingsViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTeam, textViewGP, textViewWins, textViewLost, textViewDrawn, textViewGF, textViewGA, textViewGD, textViewPts;

        public StandingsViewHolder(View itemView){
            super(itemView);

            textViewTeam = itemView.findViewById(R.id.textViewTeamName);
            textViewGP = itemView.findViewById(R.id.textViewGamesPlayed);
            textViewWins = itemView.findViewById(R.id.textViewWins);
            textViewDrawn = itemView.findViewById(R.id.textViewDrawn);
            textViewLost = itemView.findViewById(R.id.textViewLost);
            textViewGF = itemView.findViewById(R.id.textViewGoalsFor);
            textViewGA = itemView.findViewById(R.id.textViewGoalsAgainst);
            textViewGD = itemView.findViewById(R.id.textViewGoalsDifference);
            textViewPts = itemView.findViewById(R.id.textViewPoints);
        }
    }
}
