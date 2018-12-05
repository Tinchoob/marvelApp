package com.martinb.marvelapp.ui

import android.Manifest
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.MarvelApiClient
import com.martinb.marvelapp.data.model.Character

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CharacterAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissionStatus()

        // set up the RecyclerView
        recyclerView = findViewById(R.id.baseRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        MarvelApiClient.getInstance(applicationContext).data.enqueue(object : Callback<Character> {
            override fun onResponse(call: Call<Character>, response: Response<Character>) {
                val character = response.body()
                setAdapter(character!!)
            }

            override fun onFailure(call: Call<Character>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }

    private fun setAdapter(character: Character) {
        adapter = CharacterAdapter(this, character.data.results!!)
        recyclerView.adapter = adapter
    }

    fun checkPermissionStatus() {
        if (ContextCompat.checkSelfPermission(this,
                        Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    arrayOf(Manifest.permission.INTERNET),
                    214)
        }
    }
}
