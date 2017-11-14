package com.group1.mymovie;

/**
 * Created by lana on 01/11/2017.
 */

public class Movie {
    private int poster;
    private String name;
    private float rating;
    private String genre;

    public Movie(int poster, String name, float rating, String genre) {
        this.poster = poster;
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }


}
