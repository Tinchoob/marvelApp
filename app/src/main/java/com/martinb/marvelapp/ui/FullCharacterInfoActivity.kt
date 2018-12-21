package com.martinb.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result
import kotlinx.android.synthetic.main.activity_full_character_info.*

class FullCharacterInfoActivity : AppCompatActivity(), FullCharacterInfoView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_character_info)
        val bundle = intent.extras
        val characterName = bundle?.getString("characterName")
        val characterId = bundle?.getString("characterId")
        title = characterName

        comics.setOnClickListener {
            val comicsFragment = ComicsFragment.newInstance(characterId)
            val fm = this@FullCharacterInfoActivity.supportFragmentManager
            comicsFragment.show(fm, "description")

        }
    }


}
