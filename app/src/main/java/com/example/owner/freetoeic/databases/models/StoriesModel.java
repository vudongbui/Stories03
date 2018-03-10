package com.example.owner.freetoeic.databases.models;

/**
 * Created by Owner on 3/1/2018.
 */

public class StoriesModel {
    public String title;
    public String author;
    public String image;

    public StoriesModel(String title, String author, String image) {
        this.title = title;
        this.author = author;
        this.image = image;
    }

    @Override
    public String toString() {
        return "StoriesModel{" +
                "author='" + author + '\'' +
                '}';
    }
}
