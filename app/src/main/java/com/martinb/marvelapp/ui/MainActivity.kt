package com.martinb.marvelapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.model.Character
import com.martinb.marvelapp.data.model.Result
import com.martinb.marvelapp.di.marvelAppModule
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.startKoin

class MainActivity : AppCompatActivity(), MainView,OnItemClicked {

    private lateinit var adapter: CharacterAdapter
    private lateinit var characterDescriptionFragment : CharacterDescriptionFragment
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private val mainPresenter : MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startKoin(applicationContext, listOf(marvelAppModule))
        checkPermissionStatus()

        swipeRefreshLayout = findViewById(R.id.swiperefresh)

        baseRecycler.layoutManager = LinearLayoutManager(this)

        submit_search.setOnClickListener {
            if(!character_input.text.toString().equals(""))
                mainPresenter.getCharacterFilteredInfo(character_input.text.toString())
            else
                Toast.makeText(applicationContext,"Please, insert something", LENGTH_SHORT).show()
        }

        mainPresenter.attachView(this)
        swipeRefreshLayout.isRefreshing = true
        mainPresenter.getCharacterInfo()
    }


    private fun setAdapter(character: Character) {
        adapter = CharacterAdapter(this, character.data.results,this)
        baseRecycler.adapter = adapter
    }

    private fun checkPermissionStatus() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.INTERNET),
                    214)
        }
    }

    override fun charactersInfo(character: Character?) {
        swipeRefreshLayout.isRefreshing = false
        character?.let { setAdapter(character)}
    }

    override fun onItemClicked(character: Result?) {
        character?.let {characterDescriptionFragment = CharacterDescriptionFragment.newInstance(character)}
        val fm = this@MainActivity.supportFragmentManager
        characterDescriptionFragment.show(fm,"description")
    }

    override fun filteredCharactersInfo(character: Character?) {
       character?.let { adapter.setNewCharactersData(character.data.results) }
   }

}
