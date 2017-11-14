package com.group1.mymovie;

/**
 * Created by LanAnh on 06/11/2017.
 */

public class Comment {
    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    private int photo;
    private String name;
    private String comment;

    public Comment(int photo, String name, String comment) {
        this.photo = photo;
        this.name = name;
        this.comment = comment;
    }
}
