package com.example.owner.freetoeic.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owner.freetoeic.R;
import com.example.owner.freetoeic.databases.DatabaseManager;
import com.example.owner.freetoeic.databases.models.StoriesModel;
import com.squareup.picasso.Picasso;

/**
 * Created by Owner on 3/14/2018.
 */

public class StoriesActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "StoriesActivity";

    int story;
    StoriesModel storiesModel;
    ImageView ivBack;
    ImageView ivImage;
    TextView tvTitle;
    TextView tvAuthor;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        getSupportActionBar().hide();

        ivBack = findViewById(R.id.iv_back);
        ivImage = findViewById(R.id.iv_image);
        tvTitle = findViewById(R.id.tv_title);
        tvAuthor = findViewById(R.id.tv_author);

        story = getIntent().getIntExtra("item", -1);
        storiesModel = DatabaseManager.getListStory(this).get(story);
        ivBack.setOnClickListener(this);
        Picasso.with(this).load(storiesModel.image).centerCrop().fit().into(ivImage);
        tvTitle.setText(storiesModel.title);
        tvAuthor.setText(storiesModel.author);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                onBackPressed();
                break;
            case R.id.tv_streading:
                break;

        }
    }
}
