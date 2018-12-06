package com.martinb.marvelapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.DataRepository
import com.martinb.marvelapp.data.model.Character
import com.martinb.marvelapp.data.model.Result
import com.martinb.marvelapp.data.remote.MarvelApiClient
import com.martinb.marvelapp.data.remote.RemoteDataListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),RemoteDataListener,OnItemClicked {

    private lateinit var adapter: CharacterAdapter
    private lateinit var characterDescriptionFragment : CharacterDescriptionFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissionStatus()

        baseRecycler.layoutManager = LinearLayoutManager(this)

        val repository = DataRepository(MarvelApiClient.create(),this)

        repository.getData()
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
        character?.let { setAdapter(character)}
    }

    override fun onItemClicked(character: Result?) {
        character?.let {characterDescriptionFragment = CharacterDescriptionFragment.newInstance(character)}
        val fm = this@MainActivity.supportFragmentManager
        characterDescriptionFragment.show(fm,"description")
    }
}
