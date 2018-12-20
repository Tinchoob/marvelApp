package com.martinb.marvelapp.ui

import android.content.Context
import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.martinb.marvelapp.data.model.Item
import com.squareup.picasso.Picasso

class ComicsAdapter(private val mContext: Context,private val comics: List<Item>) : BaseAdapter(){


    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(85, 85)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
            imageView.setPadding(8, 8, 8, 8)
        } else {
            imageView = convertView as ImageView
        }

        Picasso.get().load(Uri.parse(String.format("%s.%s", comics[position].,character.thumbnail?.extension))).into(imageView);
        return imageView
    }

    override fun getItem(position: Int): Any? = null

    override fun getItemId(position: Int): Long = 0L

    override fun getCount(): Int {
        return comics.size
    }


}