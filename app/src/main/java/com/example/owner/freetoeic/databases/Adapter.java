package com.example.owner.freetoeic.databases;

/**
 * Created by Owner on 3/8/2018.
 */


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.owner.freetoeic.R;
import com.example.owner.freetoeic.databases.models.StoriesModel;
import com.squareup.picasso.Picasso;
import java.util.List;

public class Adapter extends BaseAdapter {

    private List<StoriesModel> storiesModelList;
    Context context;

    public Adapter(Context context, List<StoriesModel> storiesModelList) {
        this.context = context;
        this.storiesModelList = storiesModelList;
    }

    @Override
    public int getCount() {
        return storiesModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return storiesModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());

        view = layoutInflater.inflate(R.layout.item_stories, viewGroup, false);

        TextView tvAuthor = view.findViewById(R.id.tv_author);
        ImageView ivImage = view.findViewById(R.id.iv_image);
        TextView tvTitle = view.findViewById(R.id.tv_title);
        tvAuthor.setText(storiesModelList.get(i).author);
        tvTitle.setText(storiesModelList.get(i).title);

        String URL = storiesModelList.get(i).image;

        Picasso.with(context).load(URL).centerCrop().fit().into(ivImage);

        return view;
    }
}

