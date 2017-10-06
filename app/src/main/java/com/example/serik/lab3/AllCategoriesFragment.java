package com.example.serik.lab3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Serik on 02.10.17.
 */

public class AllCategoriesFragment extends Fragment {
    CategoriesAdapter categoriesAdapter;
    List<CategoryOfNews> categoryList = new ArrayList<>();
    private String title;
    private int page;

    // newInstance constructor for creating fragment with arguments
    public static AllCategoriesFragment newInstance(int page, String title) {
        AllCategoriesFragment categories = new AllCategoriesFragment();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
        categories.setArguments(args);
        return categories;
    }

    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("someInt", 0);
        title = getArguments().getString("someTitle");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.category_content, container, false);
        TextView tvLabel = (TextView) view.findViewById(R.id.categoryID);
        tvLabel.setText(page + " -- " + title);

            Date currentTime;
            currentTime = new Date(30123123);
            for (int i = 1; i < 11; i++) {

                CategoryOfNews category = new CategoryOfNews("Football");
                categoryList.add(category);
            }

        //        Implementing Recycler View
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler);
        categoriesAdapter = new CategoriesAdapter(getActivity(), categoryList);
        LinearLayoutManager llm = new LinearLayoutManager(this.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(categoriesAdapter);

        return view;
    }
}
