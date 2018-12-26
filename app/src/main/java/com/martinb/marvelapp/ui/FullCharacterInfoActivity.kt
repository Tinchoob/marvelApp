package com.martinb.marvelapp.ui

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_character_info.*

class FullCharacterInfoActivity : AppCompatActivity(), FullCharacterInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_character_info)
        val bundle = intent.extras
        val characterName = bundle?.getString("characterName")
        val characterId = bundle?.getString("characterId")
        val characterImagePath = bundle?.getString("characterImagePath")
        title = characterName

        loadBackgroundImage(characterImagePath)

        comics.setOnClickListener {
            val comicsFragment = ComicsFragment.newInstance(characterId)
            val fm = this@FullCharacterInfoActivity.supportFragmentManager
            comicsFragment.show(fm, "description")

        }

    }

    fun loadBackgroundImage(imagePath : String?){
        Picasso.get().load(Uri.parse(imagePath)).into(target)
    }

    val target = object: com.squareup.picasso.Target {
        override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {

        }

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {
        }

        override fun onBitmapLoaded(bitmap: Bitmap?, from: Picasso.LoadedFrom?) {
            val layout = findViewById<ConstraintLayout>(R.id.character_info_containter)
            layout.background = BitmapDrawable(resources,bitmap)
            layout.background.alpha = 90
        }
    }

}
