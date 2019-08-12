package com.dicoding.aplikasimoviekatalog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FilmAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Film> films;

    public void setFilms(ArrayList<Film> films) {
        this.films = films;
    }

    public FilmAdapter(Context context) {
        this.context = context;
        films = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return films.size();
    }

    @Override
    public Object getItem(int i) {
        return films.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_film, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(view);
        Film film = (Film) getItem(i);
        viewHolder.bind(film);
        return view;
    }

    private class ViewHolder {
        private TextView tvJudul, tvDeskripsi, tvRilis;
        private ImageView imgFilm;

        ViewHolder(View v) {
            tvJudul = v.findViewById(R.id.tv_judul);
            tvRilis = v.findViewById(R.id.tv_tgl_rilis);
            tvDeskripsi = v.findViewById(R.id.tv_deskripsi);
            imgFilm = v.findViewById(R.id.img_film);
        }

        void bind(Film film) {
            tvJudul.setText(film.getJudul());
            tvRilis.setText(film.getRilis());
            tvDeskripsi.setText(film.getDeskripsi());
            imgFilm.setImageResource(film.getImageFilm());
        }

    }
}
