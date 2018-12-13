package com.martinb.marvelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Result

class FullCharacterInfoActivity : AppCompatActivity() {

    private var character : Result? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_character_info)
        character = intent.getParcelableExtra("character selected")
    }


}
