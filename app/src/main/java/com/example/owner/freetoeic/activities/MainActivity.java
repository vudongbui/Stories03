package com.example.owner.freetoeic.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.owner.freetoeic.databases.Adapter;
import com.example.owner.freetoeic.databases.DatabaseManager;
import com.example.owner.freetoeic.R;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = findViewById(R.id.lv_story);
        Adapter Adapter = new Adapter(this, DatabaseManager.getListItem(this));
        listview.setAdapter(Adapter);


    }
    @Override
    protected void onStart() {
        super.onStart();

        ListView listview = findViewById(R.id.lv_story);
        Adapter Adapter = new Adapter(this, DatabaseManager.getListItem(this));
        listview.setAdapter(Adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, StoriesActivity.class);
                intent.putExtra("item", i);
                startActivity(intent);
            }
        });
    }
}
