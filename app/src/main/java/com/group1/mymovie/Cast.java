package com.group1.mymovie;

/**
 * Created by LanAnh on 04/11/2017.
 */

public class Cast {
    private String name;
    private String character;
    private int photo;

    public Cast(String name, String character, int photo) {
        this.name = name;
        this.character = character;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }
}
