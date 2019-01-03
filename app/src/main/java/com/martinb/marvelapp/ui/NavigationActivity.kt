package com.martinb.marvelapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.martinb.marvelapp.R
import com.martinb.marvelapp.ui.comics.ComicsFragment


class NavigationActivity : AppCompatActivity(), NavigationActivityView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
        val characterId = intent.getStringExtra("characterId")
        navigateTo(characterId,"")
    }

    override fun navigateTo(characterId : String,fragment: String){
        val comicsFragment = ComicsFragment.newInstance(characterId)
        val transaction = this@NavigationActivity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.comics_container,comicsFragment)
        transaction.commit()
    }
}
