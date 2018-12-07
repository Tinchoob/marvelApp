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


class CharacterAdapter(val context: Context, var data: List<Result>,val listener: OnItemClicked) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.hero_layout, parent, false))
    }

    fun setNewCharactersData(newData: List<Result>){
        this.data = newData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = data[position]
        holder.characterName.text = character.name
        holder.characterDescription.text = if(character.description == "") "No description avaliable!!" else character.description
        holder.bind(data[position], listener)
        Picasso.get().load(Uri.parse(String.format("%s/standard_fantastic.%s", character.thumbnail?.path,character.thumbnail?.extension))).into(holder.characterImage)
    }

    override fun getItemCount(): Int = data.size


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val characterImage = view.findViewById<ImageView>(R.id.characterImage)
        val characterName = view.findViewById<TextView>(R.id.characterName)
        val characterDescription = view.findViewById<TextView>(R.id.characterDescription)

        fun bind(character: Result,listener: OnItemClicked){
            itemView.setOnClickListener {
                listener.onItemClicked(character)
            }
        }
    }
}
