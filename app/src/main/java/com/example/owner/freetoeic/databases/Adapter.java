package com.example.owner.freetoeic.databases;

/**
 * Created by Owner on 3/8/2018.
 */


import android.content.Context;
import android.text.Layout;
import android.util.Log;
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
    private static final String TAG = "StoriesAdapter";
    private Context context;
    public List<StoriesModel> storiesModelList ;
    private LayoutInflater layoutInflater;

    public Adapter(Context context, List<StoriesModel> storiesModelList ){
        this.context = context;
        this.storiesModelList = storiesModelList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return storiesModelList.size();
    }

    @Override
    public Object getItem(int position) {
        return storiesModelList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        HolderView holderView;

        if(convertView == null){
            holderView = new HolderView();
            holderView.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
            holderView.ivPicture  = (ImageView) convertView.findViewById(R.id.iv_image);
            convertView.setTag(holderView);
        }else{
            holderView = (HolderView) convertView.getTag();
        }



        Log.d(TAG, "getView: " + " define comop");

        StoriesModel storiesModel = storiesModelList.get(position);

        holderView.tvTitle.setText(storiesModel.title);
        holderView.tvAuthor.setText(storiesModel.author);
        Picasso.with(context).load(storiesModel.image).into(holderView.ivPicture);
        return convertView;
    }

    private class HolderView {
        public TextView tvTitle;
        public TextView tvAuthor;
        public ImageView ivPicture;
    }
}