package com.example.owner.freetoeic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.owner.freetoeic.databases.DatabaseManager;
import com.example.owner.freetoeic.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.getInstance(this).getListTopic();
    }
}
