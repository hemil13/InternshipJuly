package com.example.internshipjuly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyHolder> {

    Context context;
    int[] productIdArray;
    int[] subCategoryIdArray;
    int[] imageArray;
    String[] nameArray;
    String[] priceArray;

    public ProductAdapter(Context context, int[] productIdArray, int[] subCategoryIdArray, int[] imageArray, String[] nameArray, String[] priceArray) {
        this.context = context;
        this.productIdArray = productIdArray;
        this.subCategoryIdArray = subCategoryIdArray;
        this.imageArray = imageArray;
        this.nameArray = nameArray;
        this.priceArray = priceArray;
    }

    @NonNull
    @Override
    public ProductAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text, price;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.product_image);
            text = itemView.findViewById(R.id.product_text);
            price = itemView.findViewById(R.id.product_price);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyHolder holder, int position) {
        holder.image.setImageResource(imageArray[position]);
        holder.text.setText(nameArray[position]);
        holder.price.setText(ConstantSp.rupees+priceArray[position]);

    }

    @Override
    public int getItemCount() {
        return productIdArray.length;
    }

}
