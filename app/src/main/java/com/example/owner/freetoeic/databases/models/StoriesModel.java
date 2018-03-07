package com.example.owner.freetoeic.databases.models;

/**
 * Created by Owner on 3/1/2018.
 */

public class StoriesModel {
    public int id;
    public String image;
    public String title;
    public String content;
    public String author;
    public int bookmark;

    public StoriesModel(int id, String image, String title, String content, String author, int bookmark) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.content = content;
        this.author = author;
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "StoriesModel{" +
                "author='" + author + '\'' +
                '}';
    }
}
