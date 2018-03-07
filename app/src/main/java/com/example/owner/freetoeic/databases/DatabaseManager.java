package com.example.owner.freetoeic.databases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.owner.freetoeic.databases.models.StoriesModel;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Owner on 3/1/2018.
 */

public class DatabaseManager {

    private static final String TAG = "DatabaseManager";
    private static final String TABLE_STORY = "tbl_short_story";
    private static DatabaseManager databaseManager;
    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    public DatabaseManager(Context context) {
        assetHelper = new AssetHelper(context);
    }


    public static DatabaseManager getInstance(Context context) {
        if (databaseManager == null) {
            databaseManager = new DatabaseManager(context);
        }
        return databaseManager;
    }

    public List<StoriesModel> getStoryModelList() {
        sqLiteDatabase = assetHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_STORY, null);



        List<StoriesModel> storyModelList = new ArrayList<>();
        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String author = cursor.getString(5);
            String image = cursor.getString(1);
            String content = cursor.getString(4);
            String title = cursor.getString(2);
            int bookmark = cursor.getInt(6);

            storyModelList.add(new StoriesModel(id, image, title, content, author, bookmark));
        }

        Log.d(TAG, "get List: " + storyModelList);

        return storyModelList;
    }
}