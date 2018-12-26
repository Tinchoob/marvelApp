package com.martinb.marvelapp.ui.comics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.martinb.marvelapp.R

class ComicsActivity : AppCompatActivity(),MainComicsView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics)
        val characterId = intent.getStringExtra("characterId")
        navigate(characterId)
    }

    private fun navigate(characterId : String){
        val comicsFragment = ComicsFragment.newInstance(characterId)
        val transaction = this@ComicsActivity.supportFragmentManager.beginTransaction()
        transaction.replace(R.id.comics_container,comicsFragment)
        transaction.commit()
    }
}
