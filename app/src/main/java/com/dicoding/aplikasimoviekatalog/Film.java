package com.dicoding.aplikasimoviekatalog;

import android.os.Parcel;
import android.os.Parcelable;

public class Film implements Parcelable {
    private String judul;
    private String deskripsi;
    private String rilis;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getRilis() {
        return rilis;
    }

    public void setRilis(String rilis) {
        this.rilis = rilis;
    }

    public int getImageFilm() {
        return imageFilm;
    }

    public void setImageFilm(int imageFilm) {
        this.imageFilm = imageFilm;
    }

    private int imageFilm;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeString(this.deskripsi);
        dest.writeString(this.rilis);
        dest.writeInt(this.imageFilm);
    }

    public Film() {
    }

    protected Film(Parcel in) {
        this.judul = in.readString();
        this.deskripsi = in.readString();
        this.rilis = in.readString();
        this.imageFilm = in.readInt();
    }

    public static final Parcelable.Creator<Film> CREATOR = new Parcelable.Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel source) {
            return new Film(source);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };
}
