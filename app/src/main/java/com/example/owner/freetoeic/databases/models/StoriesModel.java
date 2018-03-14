package com.example.owner.freetoeic.databases.models;

/**
 * Created by Owner on 3/1/2018.
 */

public class StoriesModel {
    public String title;
    public String author;
    public String image;
    public String description;
    public String content;
    public int id;
    public int bookmark;

    public StoriesModel(String title, String author, String image, String description, String content, int id, int bookmark) {
        this.title = title;
        this.author = author;
        this.image = image;
        this.description = description;
        this.content = content;
        this.id = id;
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "StoriesModel{" +
                "author='" + author + '\'' +
                '}';
    }
}
