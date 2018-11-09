package com.martinb.marvelapp.ui;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.martinb.marvelapp.R;
import com.martinb.marvelapp.data.model.Data;
import com.martinb.marvelapp.data.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<Result> mCharacter;
    private LayoutInflater mInflater;


    CharacterAdapter(Context context, List<Result> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mCharacter = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.hero_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Result character = mCharacter.get(position);
        holder.characterName.setText(character.getName());
        Picasso.get().load(Uri.parse(character.getResourceURI())).into(holder.characterImage);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mCharacter.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView characterName;
        ImageView characterImage;

        ViewHolder(View itemView) {
            super(itemView);
            characterImage = itemView.findViewById(R.id.characterImage);
            characterName = itemView.findViewById(R.id.characterName);

        }

    }

}