package com.example.invernessct.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.invernessct.R;
import com.example.invernessct.models.SquadObject;
import com.example.invernessct.models.StandingsTableObject;
import com.squareup.picasso.Picasso;

import java.io.InputStream;
import java.util.List;

public class SquadAdapter extends RecyclerView.Adapter<SquadAdapter.SquadViewHolder> {

    // Context object
    private Context mContext;
    // List of standings objects
    private List<SquadObject> squadList;

    public SquadAdapter(Context mContext, List<SquadObject> squadList) {
        this.mContext = mContext;
        this.squadList = squadList;
    }

    @NonNull
    @Override
    public SquadViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.recyclerview_squad, viewGroup, false);
        return new SquadViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SquadViewHolder holder,int position) {
        SquadObject squadObject = squadList.get(position);

        holder.textViewPlayerName.setText(squadObject.getPlayer_name());
        holder.textViewPlayerNo.setText(squadObject.getPlayer_number());
        holder.textViewPlayerDoB.setText(squadObject.getPlayer_dob());
        holder.textViewPlaceOfBirth.setText(squadObject.getPlace_of_birth());
        holder.textViewPlayerAge.setText(squadObject.getAge());
        holder.textViewPlayerHeight.setText(squadObject.getHeight());
        holder.textViewPlayerCitizenship.setText(squadObject.getCitizenship());
        holder.textViewPlayerPosition.setText(squadObject.getPlayer_position());
        holder.textViewPlayerFoot.setText(squadObject.getFoot());
        holder.textViewPlayerJoined.setText(squadObject.getJoined());
        holder.textViewPlayerContract.setText(squadObject.getContract_until());


        String imageURL = "http://www.kamilwierzbicki.com/main/images/players/" + squadObject.getImage();

        Picasso.get().load(imageURL).into(holder.imageViewPlayer);
    }

    @Override
    public int getItemCount() {
        return squadList.size();
    }

    class SquadViewHolder extends RecyclerView.ViewHolder{

        TextView textViewPlayerName, textViewPlayerNo, textViewPlayerDoB, textViewPlaceOfBirth, textViewPlayerAge, textViewPlayerHeight,
                textViewPlayerCitizenship, textViewPlayerPosition, textViewPlayerFoot, textViewPlayerJoined, textViewPlayerContract;
        ImageView imageViewPlayer;

        public SquadViewHolder(View itemView){
            super(itemView);



            imageViewPlayer = itemView.findViewById(R.id.imageViewPlayer);
            textViewPlayerName = itemView.findViewById(R.id.textViewPlayerName);
            textViewPlayerNo = itemView.findViewById(R.id.textViewPlayerNo);
            textViewPlayerDoB = itemView.findViewById(R.id.textViewPlayerDoB);
            textViewPlaceOfBirth = itemView.findViewById(R.id.textViewPlaceOfBirth);
            textViewPlayerAge = itemView.findViewById(R.id.textViewPlayerAge);
            textViewPlayerHeight = itemView.findViewById(R.id.textViewPlayerHeight);
            textViewPlayerCitizenship = itemView.findViewById(R.id.textViewPlayerCitizenship);
            textViewPlayerPosition = itemView.findViewById(R.id.textViewPlayerPosition);
            textViewPlayerFoot = itemView.findViewById(R.id.textViewPlayerFoot);
            textViewPlayerJoined = itemView.findViewById(R.id.textViewPlayerJoined);
            textViewPlayerContract = itemView.findViewById(R.id.textViewPlayerContract);
        }
    }
}
