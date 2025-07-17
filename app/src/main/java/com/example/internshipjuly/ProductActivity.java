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

public class ProductActivity extends AppCompatActivity {

    int[] productIdArray = {1,2,3,4,5,6,7,8,9};
    int[] subCategoryIdArray = {1,1,1,2,2,2,3,3,3};
    int[] imageArray = {R.drawable.redmi, R.drawable.oneplus, R.drawable.sony,
                            R.drawable.sony_headphones, R.drawable.noise, R.drawable.airpods_max,
                            R.drawable.boat120, R.drawable.noiseaura, R.drawable.airpodspro2 };
    String[] nameArray = {"Redmi", "OnePlus", "Sony",
                            "Sony Headphones", "Noise Headphones", "Airpods Max",
                            "Boat Earbuds", "Noise Aura Earbuds ", "Airpods Pro 2"};
    String[] priceArray = {"15000", "20000", "35000", "7000", "3000", "10000", "1500", "2000", "2500"};

    RecyclerView product_recycler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        product_recycler = findViewById(R.id.product_recycler);

        product_recycler.setLayoutManager(new LinearLayoutManager(ProductActivity.this));
        product_recycler.setItemAnimator(new DefaultItemAnimator());


        ProductAdapter adapter = new ProductAdapter(ProductActivity.this, productIdArray, subCategoryIdArray, imageArray, nameArray, priceArray);
        product_recycler.setAdapter(adapter);




    }
}