package com.martinb.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result
import kotlinx.android.synthetic.main.activity_full_character_info.*

class FullCharacterInfoActivity : AppCompatActivity(),FullCharacterInfoView{

    private var character : Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_character_info)
        character = intent.getParcelableExtra("selected character")
        character.let { character -> title = character?.name }

        comics.setOnClickListener {
            character.comics.
            val comicsFragment = ComicsFragment.newInstance(character.comics)
            val fm = this@MainActivity.supportFragmentManager
            characterDescriptionFragment.show(fm,"description")
        }
    }


}
