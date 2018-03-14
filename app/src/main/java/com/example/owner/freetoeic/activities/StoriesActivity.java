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

    StoriesModel storiesModel2;
    ImageView ivBack;
    ImageView ivBookmark2;
    ImageView ivImage2;
    TextView tvTitle2;
    TextView tvAuthor2;
    TextView tvDescription2;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        getSupportActionBar().hide();

        ivBack = findViewById(R.id.iv_back);
        ivImage2 = findViewById(R.id.iv_image2);
        tvTitle2 = findViewById(R.id.tv_title2);
        tvAuthor2 = findViewById(R.id.tv_author);
        tvDescription2 = findViewById(R.id.tv_main2);

        showStory();
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
    public void showStory() {
        ivBack.setOnClickListener(this);

        Picasso.with(this)
                .load(storiesModel2.image)
                .centerCrop()
                .fit()
                .into(ivImage2);
        tvTitle2.setText(storiesModel2.title);
        tvAuthor2.setText(storiesModel2.author);
        tvDescription2.setText(storiesModel2.description);

    }
}
