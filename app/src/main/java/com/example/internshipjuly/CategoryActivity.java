package com.example.internshipjuly;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryActivity extends AppCompatActivity {

    int[] idArray = {1,2,3};
    int[] imageArray = {R.drawable.electronics, R.drawable.clothes, R.drawable.books};
    String[] nameArray = {"Electronics","Clothes","Books"};

    RecyclerView category_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category_recycler = findViewById(R.id.category_recycler);

        category_recycler.setLayoutManager(new LinearLayoutManager(CategoryActivity.this));

        CategoryAdapter adapter = new CategoryAdapter(CategoryActivity.this, idArray, imageArray, nameArray);
        category_recycler.setAdapter(adapter);


    }
}