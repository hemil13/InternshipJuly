package com.example.internshipjuly;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class SubCategoryActivity extends AppCompatActivity {

    int[] subCategoryIdArray = {1,2,3,4,5,6,7,8,9};
    int[] categoryIdArray = {1,1,1,2,2,2,3,3,3};
    int[] imageArray = {R.drawable.mobile, R.drawable.headphone, R.drawable.earbuds,
                            R.drawable.thsirt, R.drawable.shirt, R.drawable.jeans,
                            R.drawable.novel, R.drawable.horror, R.drawable.fiction};
    String[] nameArray = {"Mobile", "Headphones", "Earbuds",
                            "T-Shirt", "Shirt", "Jeans",
                            "Novel", "Horror", "Fiction"};

    RecyclerView subcategory_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_category);

        subcategory_recycler = findViewById(R.id.subcategory_recycler);

        subcategory_recycler.setLayoutManager(new LinearLayoutManager(SubCategoryActivity.this));
        subcategory_recycler.setItemAnimator(new DefaultItemAnimator());

        SubCategoryAdapter adapter = new SubCategoryAdapter(SubCategoryActivity.this, subCategoryIdArray, categoryIdArray, imageArray, nameArray);
        subcategory_recycler.setAdapter(adapter);


    }
}