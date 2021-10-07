package com.my.animekutv;

import android.os.Parcel;
import android.os.Parcelable;

public class animelist implements Parcelable {

    private String judul;
    private int eps;
    private double rating;
    private String genre;
    private String deskripsi;

    public animelist(String judul, int eps, double rating, String genre, String deskripsi) {
        this.judul = judul;
        this.eps = eps;
        this.rating = rating;
        this.genre = genre;
        this.deskripsi = deskripsi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public int getEps() {
        return eps;
    }

    public void setEps(int eps) {
        this.eps = eps;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.judul);
        dest.writeInt(this.eps);
        dest.writeDouble(this.rating);
        dest.writeString(this.genre);
        dest.writeString(this.deskripsi);
    }

    public void readFromParcel(Parcel source) {
        this.judul = source.readString();
        this.eps = source.readInt();
        this.rating = source.readDouble();
        this.genre = source.readString();
        this.deskripsi = source.readString();
    }

    protected animelist(Parcel in) {
        this.judul = in.readString();
        this.eps = in.readInt();
        this.rating = in.readDouble();
        this.genre = in.readString();
        this.deskripsi = in.readString();
    }

    public static final Creator<animelist> CREATOR = new Creator<animelist>() {
        @Override
        public animelist createFromParcel(Parcel source) {
            return new animelist(source);
        }

        @Override
        public animelist[] newArray(int size) {
            return new animelist[size];
        }
    };
}
