package com.martinb.marvelapp.ui.comics

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.ComicInformation
import com.squareup.picasso.Picasso

class ComicsAdapter(private val mContext: Context,private val comics: List<ComicInformation>) : BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val comic = comics[position]
        val comicView: View


        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            val layoutInflater = LayoutInflater.from(mContext)
            comicView = layoutInflater.inflate(R.layout.comic_item_layout,parent,false)
        }
        else {
            comicView = convertView
        }

        val comicImage = comicView.findViewById<ImageView>(R.id.comic_image)
        val comicName = comicView.findViewById<TextView>(R.id.comic_title)
        val comicPrice = comicView.findViewById<TextView>(R.id.comic_price)
        val comicDescription = comicView.findViewById<TextView>(R.id.comic_description)


        Picasso.get().load(Uri.parse("${comic.thumbnail.path}/standard_fantastic.${comic.thumbnail.extension}")).into(comicImage)
        comicName.text = comic.title
        comicDescription.text = comic.description
        comicPrice.text = "$${comic.prices[0].price}"
        return comicView
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int {
        return comics.size
    }


}