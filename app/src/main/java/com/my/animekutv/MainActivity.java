package com.my.animekutv;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    rvAdapter rvadapter;
    ArrayList<animelist> objAnime = new ArrayList<>();
    String[] keyword;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewSetting(); //call function
        animelistadd();
        autocompleteSetting();
        spinnerSetting();
    }

    //list of object
    private void animelistadd() {
        keyword = new String[]{"Tokyo Ghoul", "Re Zero", "Boku No Hero", "Attack on Titan", "Dororo", "Tensura", "Danmachi", "Naruto", "Akame ga Kill", "Attack on Titan s2"};

        objAnime.add(new animelist("Attack On Titan S1", 25, 8.51, "Action", "Anime Attack on Titan bercerita tentang umat manusia yang dibantai sejak berabad-abad yang lalu hingga hampir punah oleh makhluk mengerikan menyerupai manusia yang disebut Titan. Hal ini memaksa manusia untuk bersembunyi dan diam dalam ketakutan di balik tembok konsentris yang sangat tinggi dan besar."));
        objAnime.add(new animelist("Black Clover", 170, 8.05, "Action", "Black Clover bercerita tentang 2 anak yatim piatu bernama Asta dan Yuno. Mereka dibesarkan bersama di gereja yang sama dan sejak itu tak terpisahkan. Sebagai anak-anak, mereka berjanji akan saling bersaing untuk melihat siapa yang akan menjadi Kaisar Magus berikutnya."));
        objAnime.add(new animelist("Dr. Stone", 24, 8.31, "Adventure", "3700 tahun setelah kilatan cahaya hijau misterius mengubah umat manusia menjadi batu, seorang remaja jenius bernama Senku Ishigami bangkit dan menemukan dirinya di dunia tempat di mana semua jejak peradaban manusia telah terkikis oleh waktu. Senku yang menyadari bahwa dirinya dibangkitkan dengan asam nitrat, menghidupkan kembali temannya yang bernama Taiju Oki dan teman sekelas mereka Yuzuriha Ogawa untuk membangun kembali peradaban mereka."));
        objAnime.add(new animelist("Tokyo Ghoul", 13, 7.8, "Horror", "okyo Ghoul yang bercerita tentang makhluk aneh yang memakan manusia, mereka disebut “Ghoul”. Seorang mahasiswa, Kaneki Ken, menjalani kehidupan normal dan telah jatuh cinta dengan seorang gadis. Tapi, setelah kencan pertama mereka ternyata gadis itu adalah seorang Ghoul. dia pun benar-benar trauma, dan entah bagaimana dia bisa selamat dari Ghoul yang tiba-tiba mati dengan sendirinya. Apa yang akan terjadi saat para dokter menanamkan beberapa organ padanya, agar dia bisa bertahan hidup?"));
    }

    //Fungsi Recycler View
    private void recyclerViewSetting() {
        recyclerView = findViewById(R.id.recyclerview); //set untuk recycler view dalam xml/front end
        rvadapter = new rvAdapter(objAnime); //recyclerview adapter untuk object di atas
        recyclerView.setAdapter(rvadapter); //set adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //set layout linear
    }

    private void autocompleteSetting() {
        AutoCompleteTextView editText = findViewById(R.id.search); //set untuk item edittext front end
        ArrayAdapter<String> adapterSearch = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, keyword); //adapter autocomplete dan call dari string keyword
        editText.setAdapter(adapterSearch); //set adapter
    }

    private void spinnerSetting() {
        spinner = findViewById(R.id.genre); //set item spinner front end
        ArrayAdapter<CharSequence> spAdapter =ArrayAdapter.createFromResource(this, R.array.genre, android.R.layout.simple_spinner_item); //create adapter spinner
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item); //set view spinner/model
        spinner.setAdapter(spAdapter); //set adapter
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //set item yang dipilih dan memanggil toast
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String spitem = adapterView.getItemAtPosition(i).toString(); //mengambil item di posisi
                Toast.makeText(getApplicationContext(), "Gagal memuat genre " + spitem, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}