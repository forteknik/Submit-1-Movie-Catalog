package com.dicoding.aplikasimoviekatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailFilm extends AppCompatActivity{
    TextView tvJudulFilm, tvRilis, tvDeskripsi;
    Button btnTonton;
    ImageView imgFilm;
    public static final String EXTRA_FILM = "extra_film";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_film);
        tvJudulFilm = findViewById(R.id.tv_judul);
        tvRilis = findViewById(R.id.tv_tgl_rilis);
        tvDeskripsi = findViewById(R.id.tv_deskripsi);
        imgFilm = findViewById(R.id.img_film);
        btnTonton = findViewById(R.id.btn_tonton);

        Film film = getIntent().getParcelableExtra(EXTRA_FILM);
        tvJudulFilm.setText(film.getJudul());
        tvRilis.setText(film.getRilis());
        tvDeskripsi.setText(film.getDeskripsi());
        imgFilm.setImageResource(film.getImageFilm());
    }
}
