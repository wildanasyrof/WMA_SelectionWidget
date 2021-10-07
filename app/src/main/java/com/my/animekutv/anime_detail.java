package com.my.animekutv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class anime_detail extends AppCompatActivity {

    TextView txtJudul, txtEpisode, txtRating, txtGenre, txtDeskripsi;
    String[] episode;
    ListView listViewEpisode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_detail);

        Intent intent = getIntent();

        //set item pada front end

        txtJudul = findViewById(R.id.dtljudul);
        txtEpisode = findViewById(R.id.dtlepisode);
        txtRating = findViewById(R.id.dtlrating);
        txtGenre = findViewById(R.id.dtlgenre);
        txtDeskripsi = findViewById(R.id.dtldeskripsi);

        //call value dari class anime list sesuai kodenya dan fungsinya
        animelist anime = intent.getParcelableExtra("ANIME");
        txtJudul.setText(anime.getJudul());
        txtEpisode.setText(String.valueOf(anime.getEps())); //tostring karena integer
        txtRating.setText(String.valueOf(anime.getRating())); //tostring karena double
        txtGenre.setText(anime.getGenre());
        txtDeskripsi.setText(anime.getDeskripsi());

        //mengisi string[] episode sesuai value episode dalam array linklist
        int x = anime.getEps();
        episode = new String[x];
        for(int i = 0; i < x; i++){
            int arrItem = x - i;
            episode[i] = ("Episode " +String.valueOf(arrItem));

        }

        //list view adapter
        listViewEpisode = findViewById(R.id.lvEpisode);
        ArrayAdapter<String> lvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, episode); //create new adapter, dengan string episode yang dibuat otomatis sesuai value
        listViewEpisode.setAdapter(lvAdapter); //set adapter

        listViewEpisode.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String episode = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), "Gagal memuat " + episode, Toast.LENGTH_SHORT).show();

            }
        });

    }
}