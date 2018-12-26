package com.martinb.marvelapp.ui

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.martinb.marvelapp.R
import com.martinb.marvelapp.ui.comics.ComicsActivity
import com.martinb.marvelapp.ui.comics.ComicsFragment
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

        Picasso.get().load(Uri.parse(characterImagePath)).into(target)

        comics.setOnClickListener {
           val intent = Intent(this,ComicsActivity::class.java)
            intent.putExtra("characterId",characterId)
            startActivity(intent)
        }

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
