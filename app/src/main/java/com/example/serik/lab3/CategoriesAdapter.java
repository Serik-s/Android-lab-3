package com.example.serik.lab3;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Serik on 06.10.17.
 */

public class CategoriesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    List<CategoryOfNews> categoryList;


    public CategoriesAdapter(Context context, List<CategoryOfNews> categoryList) {
        mContext = context;
        this.categoryList = categoryList;
        for (int i = 0; i < categoryList.size(); i++){
            System.out.println(categoryList.get(i).toString());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("ViewHolder", "Create");
        View view;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);

        return new CategoriesAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("ViewHolder", "Bind");
        Log.d("position", String.valueOf(position));
        CategoriesAdapter.MyViewHolder viewHolder = (CategoriesAdapter.MyViewHolder) holder;
        CategoryOfNews category = categoryList.get(position);
        viewHolder.setPosition(position);
        viewHolder.categoryName.setText(category.getName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView categoryName;
        int position;

        public MyViewHolder(View itemView) {
            super(itemView);
            categoryName = (TextView) itemView.findViewById(R.id.categoryName);
//            articleDate = (TextView) itemView.findViewById(R.id.articleDate);

//            itemView.setOnClickListener(this);
        }


        public void setPosition(int position){
            this.position = position;
        }

//        @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(v.getContext(), ArticleDetailsActivity.class);
//            intent.putExtra("article", categoryList.get(position));
//            mContext.startActivity(intent);
//        }
    }
}
