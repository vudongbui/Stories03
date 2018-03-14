package com.example.owner.freetoeic.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.owner.freetoeic.databases.models.StoriesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Owner on 3/1/2018.
 */

public class DatabaseManager {
    private static SQLiteDatabase sqLiteDatabase;
    private static AssetHelper assetHelper;

    public static List<StoriesModel> getListItem(Context context) {
        assetHelper = new AssetHelper(context);
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<StoriesModel> itemModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from tbl_short_story", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            String title = cursor.getString(2);
            String author = cursor.getString(5);
            String image = cursor.getString(1);
            String description = cursor.getString(3);
            String content = cursor.getString(4);
            int id = cursor.getInt(0);
            int bookmark = cursor.getInt(6);

            StoriesModel storiesModel = new StoriesModel(title, author, image,description,content,id,bookmark);
            itemModelList.add(storiesModel);

            cursor.moveToNext();
        }

        return itemModelList;
    }
}