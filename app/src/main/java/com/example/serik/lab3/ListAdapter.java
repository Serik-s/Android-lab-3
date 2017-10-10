package com.example.serik.lab3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Serik on 02.10.17.
 */

public class ListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<Article> newsList;


    public ListAdapter(Context context, List<Article> newsList) {
        mContext = context;
        this.newsList = newsList;
        for (int i = 0; i < newsList.size(); i++){
            System.out.println(newsList.get(i).toString());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewHolder", "Create");
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("ViewHolder", "Bind");
        Log.d("position", String.valueOf(position));
            MyViewHolder viewHolder = (MyViewHolder) holder;
            Article article = newsList.get(position);
            viewHolder.setPosition(position);
            viewHolder.articleTitle.setText(article.getTitle().getPrintHeadline());
            viewHolder.articleDate.setText(article.getDate());
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView articleTitle;
        TextView articleDate;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            articleTitle = (TextView) itemView.findViewById(R.id.articleTitle);
            articleDate = (TextView) itemView.findViewById(R.id.articleDate);

            itemView.setOnClickListener(this);
        }


        public void setPosition(int position){
            this.position = position;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ArticleDetailsActivity.class);
            intent.putExtra("article", newsList.get(position));
            mContext.startActivity(intent);
        }
    }
}
