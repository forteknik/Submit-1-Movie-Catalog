package com.dicoding.aplikasimoviekatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataRilis;
    private String[] dataDeskripsi;
    private TypedArray dataImage;
    private FilmAdapter adapter;
    private  ArrayList<Film> films;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new FilmAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Intent detailIntent = new Intent(MainActivity.this, DetailFilm.class);
                detailIntent.putExtra(DetailFilm.EXTRA_FILM, films.get(i));
                startActivity(detailIntent);
            }
        });
    }

    private void addItem(){
        films = new ArrayList<>();
        for (int i = 0; i < dataJudul.length; i++){
            Film film = new Film();
            film.setJudul(dataJudul[i]);
            film.setRilis(dataRilis[i]);
            film.setDeskripsi(dataDeskripsi[i]);
            film.setImageFilm(dataImage.getResourceId(i, -1));
            films.add(film);
        }
        adapter.setFilms(films);
    }

    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataRilis = getResources().getStringArray(R.array.data_rilis);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataImage = getResources().obtainTypedArray(R.array.data_image);
    }
}
