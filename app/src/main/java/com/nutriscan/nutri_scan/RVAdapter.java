package com.nutriscan.nutri_scan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

/**
 * Created by emilyzhong on 1/21/18.
 */

public class RVAdapter extends RecyclerView.Adapter<ItemViewHolder>{
    List<Food> foodList;
    Context context;

    RVAdapter(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_item, parent, false);
        ItemViewHolder ivh = new ItemViewHolder(v);
        return ivh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        holder.foodName.setText(foodList.get(position).name);

        String statsString = "";
        Map stats = foodList.get(position).stats;

        // TODO: consider including other stats.
        statsString += stats.get("calories") + " Calories";

        holder.foodDetails.setText(statsString);
//        holder.foodPhoto.setImageResource(foodList.get(position).photoId);

        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: set this to the intnt thing
                Toast.makeText(context, "Index position is: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();

    }

}
