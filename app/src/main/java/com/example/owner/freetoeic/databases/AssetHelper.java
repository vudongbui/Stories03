package com.example.owner.freetoeic.databases;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by Owner on 3/1/2018.
 */

public class AssetHelper extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "toeic_600.db";
    private static final int DATABASE_VERSION = 2;

    public AssetHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
