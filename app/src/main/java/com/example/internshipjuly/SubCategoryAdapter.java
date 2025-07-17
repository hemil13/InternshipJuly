package com.example.internshipjuly;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SubCategoryAdapter extends RecyclerView.Adapter<SubCategoryAdapter.MyHolder> {

    Context context;
    int[] subCategoryIdArray;
    int[] categoryIdArray;
    int[] imageArray;
    String[] nameArray;

    ArrayList<SubcategoryList> arrayList;

    SharedPreferences sp;



//    public SubCategoryAdapter(Context context, int[] subCategoryIdArray, int[] categoryIdArray, int[] imageArray, String[] nameArray) {
//        this.context = context;
//        this.subCategoryIdArray = subCategoryIdArray;
//        this.categoryIdArray = categoryIdArray;
//        this.imageArray = imageArray;
//        this.nameArray = nameArray;
//        sp = context.getSharedPreferences(ConstantSp.pref, Context.MODE_PRIVATE);
//    }



    public SubCategoryAdapter(Context context, ArrayList<SubcategoryList> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

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

//        if(categoryIdArray[position] == Integer.parseInt(sp.getString(ConstantSp.categoryid,""))){
//
//            holder.image.setImageResource(imageArray[position]);
//            holder.text.setText(nameArray[position]);
//        }

        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.text.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.edit().putString(ConstantSp.subcategoryid, String.valueOf(arrayList.get(position).getSubcategoryId())).commit();

                Intent intent = new Intent(context, ProductActivity.class);
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
