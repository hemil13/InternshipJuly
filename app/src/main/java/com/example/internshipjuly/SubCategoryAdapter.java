package com.example.internshipjuly;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyHolder> {

    Context context;
    int[] subCategoryIdArray;
    int[] categoryIdArray;
    int[] imageArray;
    String[] nameArray;

    SharedPreferences sp;

    public SubCategoryAdapter(Context context, int[] subCategoryIdArray, int[] categoryIdArray, int[] imageArray, String[] nameArray) {
        this.context = context;
        this.subCategoryIdArray = subCategoryIdArray;
        this.categoryIdArray = categoryIdArray;
        this.imageArray = imageArray;
        this.nameArray = nameArray;
        sp = context.getSharedPreferences(ConstantSp.pref, Context.MODE_PRIVATE);
    }

    @NonNull
    @Override
    public SubCategoryAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView text;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.category_image);
            text = itemView.findViewById(R.id.category_text);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SubCategoryAdapter.MyHolder holder, int position) {

        if(categoryIdArray[position] == Integer.parseInt(sp.getString(ConstantSp.categoryid,""))){
            holder.image.setImageResource(imageArray[position]);
            holder.text.setText(nameArray[position]);
        }
    }

    @Override
    public int getItemCount() {
        return subCategoryIdArray.length;
    }
}
