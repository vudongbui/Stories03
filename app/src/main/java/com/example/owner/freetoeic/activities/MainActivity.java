package com.example.owner.freetoeic.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.owner.freetoeic.databases.Adapter;
import com.example.owner.freetoeic.databases.DatabaseManager;
import com.example.owner.freetoeic.R;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.lv_story);
        Adapter Adapter = new Adapter(this, DatabaseManager.getListItem(this));
        listview.setAdapter(Adapter);
    }
}
