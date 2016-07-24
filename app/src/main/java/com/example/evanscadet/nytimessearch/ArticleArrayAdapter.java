package com.example.evanscadet.nytimessearch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Evans Cadet on 7/21/2016.
 */
public class ArticleArrayAdapter extends ArrayAdapter<Article> {

    public ArticleArrayAdapter(Context context, List<Article> articles) {
        super(context, android.R.layout.simple_list_item_1, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // get the data item for the position
        Article article = this.getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        // not using a recycled view -> inflate the layout
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result, parent, false);

        }
        // find the image view
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);

        // clear out recycled image from convertView from last time
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView. findViewById(R.id.tvTitle);

        tvTitle.setText(article.getHeadline());

        // populate the thumbnail image
        // remote download the image in the background

        String thumbnail = article.getThumbNail();


        if (!TextUtils.isEmpty(thumbnail)) {
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        }

        return convertView;

    }
}
