package com.martinb.marvelapp.ui

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result
import com.squareup.picasso.Picasso


class CharacterAdapter(val context: Context, val data: List<Result>) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.hero_layout, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = data[position]
        holder.characterName.text = character.name
        Picasso.get().load(Uri.parse(String.format("%s.%s", character.thumbnail?.path,character.thumbnail?.extension))).into(holder.characterImage);
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val characterImage = view.findViewById<ImageView>(R.id.characterImage)
        val characterName = view.findViewById<TextView>(R.id.characterName)
    }
}
