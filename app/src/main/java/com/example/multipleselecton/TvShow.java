package com.example.multipleselecton;

public class TvShow {
    String name,createdBy,story;
    int image;
    Boolean isSelected = false;
    float rating;

    public TvShow(String name, String createdBy, String story, int image, float rating) {
        this.name = name;
        this.createdBy = createdBy;
        this.story = story;
        this.image = image;
        this.rating = rating;
    }
}
