package com.example.internshipjuly;

import static android.content.Context.MODE_PRIVATE;

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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyHolder> {

    Context Context;
    int[] idArray;
    int[] imageArray;
    String[] nameArray;

    ArrayList<CategoryList> arrayList;
    SharedPreferences sp;

//    public CategoryAdapter(Context Context, int[] idArray, int[] imageArray, String[] nameArray) {
//        this.Context = Context;
//        this.idArray = idArray;
//        this.imageArray = imageArray;
//        this.nameArray = nameArray;
//
//        sp = Context.getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);
//    }


    public CategoryAdapter(Context Context, ArrayList<CategoryList> arrayList) {
        this.Context = Context;
        this.arrayList = arrayList;

        sp = Context.getSharedPreferences(ConstantSp.pref, MODE_PRIVATE);
    }

    @NonNull
    @Override
    public CategoryAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new MyHolder(view);
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView text;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.category_image);
            text = itemView.findViewById(R.id.category_text);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.MyHolder holder, int position) {
//        holder.image.setImageResource(imageArray[position]);
//        holder.text.setText(nameArray[position]);


        holder.image.setImageResource(arrayList.get(position).getImage());
        holder.text.setText(arrayList.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                sp.edit().putString(ConstantSp.categoryid, String.valueOf(idArray[position])).commit();

                sp.edit().putString(ConstantSp.categoryid, String.valueOf(arrayList.get(position).getCategoryId())).commit();

                Intent intent = new Intent(Context, SubCategoryActivity.class);
                Context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
