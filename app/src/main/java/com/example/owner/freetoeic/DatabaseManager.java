package com.example.owner.freetoeic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Owner on 3/1/2018.
 */

public class DatabaseManager {
    private static final String TABLE_TOPIC = "tbl_topic";
    private static final String TABLE_WORD = "tbl_word";

    private SQLiteDatabase sqLiteDatabase;
    private AssetHelper assetHelper;

    private static DatabaseManager databaseManager;

    public static DatabaseManager getInstance(Context context){
        if (databaseManager == null){
            databaseManager = new DatabaseManager(context);
        }
        return  databaseManager;
    }

    public DatabaseManager(Context context) {
        assetHelper =  new AssetHelper(context);
    }

    public List<TopicModel> getListTopic(){
        sqLiteDatabase = assetHelper.getReadableDatabase();

        List<TopicModel> topicModelList = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from " + TABLE_TOPIC,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()){
            //read
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String imageUrl = cursor.getString(3);
            String category = cursor.getString(4);
            String color = cursor.getString(5);
            String lastTime = cursor.getString(6);

            TopicModel topicModel = new TopicModel(id,name,imageUrl,category,color,lastTime);
            topicModelList.add(topicModel);
            //next
            cursor.moveToNext();
        }
        Log.d(TAG, "getListTopic: "+ topicModelList);
        return topicModelList;
    }
}
