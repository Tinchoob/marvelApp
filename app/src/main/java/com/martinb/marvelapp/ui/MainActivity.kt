package com.martinb.marvelapp.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.martinb.marvelapp.BuildConfig
import com.martinb.marvelapp.R
import com.martinb.marvelapp.data.DataRepository
import com.martinb.marvelapp.data.model.Character
import com.martinb.marvelapp.data.remote.MarvelApiService
import com.martinb.marvelapp.data.remote.RemoteDataListener
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(),RemoteDataListener {

    private lateinit var adapter: CharacterAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkPermissionStatus()

        // set up the RecyclerView
        recyclerView = findViewById(R.id.baseRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val repository = DataRepository(create(),this)

        repository.getData()
    }


    companion object {
        fun create(): MarvelApiService {

            val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                    .build()

            val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(BuildConfig.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()

            return retrofit.create(MarvelApiService::class.java)
        }
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

    override fun charactersInfo(character: Character?) {
        if(character != null) setAdapter(character)
    }
}
