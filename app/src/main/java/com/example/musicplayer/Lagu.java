package com.example.musicplayer;

public class Lagu {
    private long id;
    private String judul;
    private String artist;

    public Lagu(long id, String judul, String artist) {
        this.id = id;
        this.judul = judul;
        this.artist = artist;
    }

    public long getId() {
        return id;
    }

    public String getJudul() {
        return judul;
    }

    public String getArtist() {
        return artist;
    }
}
