package com.martinb.marvelapp.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.martinb.marvelapp.R;
import com.martinb.marvelapp.data.MarvelApiClient;
import com.martinb.marvelapp.data.model.Character;
import com.martinb.marvelapp.data.model.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements OnItemClicked,CharacterFragment.OnFragmentInteractionListener {

    private CharacterAdapter adapter;
    private RecyclerView recyclerView;
    private CharacterFragment characterDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermissionStatus();

        // set up the RecyclerView
        recyclerView = findViewById(R.id.baseRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MarvelApiClient.getInstance(getApplicationContext()).getData().enqueue(new Callback<Character>() {
            @Override
            public void onResponse(Call<Character> call, Response<Character> response) {
                Character character = response.body();
                setAdapter(character);
            }

            @Override
            public void onFailure(Call<Character> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setAdapter(Character character){
        adapter = new CharacterAdapter(this, character.getData().getResults());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickedListener(this);
    }
    public void checkPermissionStatus() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.INTERNET},
                    214);
        }
    }

    @Override
    public void onItemSelected(Result result) {
        characterDescription = CharacterFragment.newInstance("","");
        characterDescription.setSelectedCharacter(result);
        FragmentManager fm = getSupportFragmentManager();
        characterDescription.show(fm,"show");

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
