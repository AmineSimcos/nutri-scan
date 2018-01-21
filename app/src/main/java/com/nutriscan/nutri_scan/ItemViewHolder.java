package com.nutriscan.nutri_scan;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by emilyzhong on 1/21/18.
 */

public class ItemViewHolder extends RecyclerView.ViewHolder {
    CardView cv;
    TextView foodName;
    TextView foodDetails;
    ImageView foodPhoto;

    ItemViewHolder(View itemView) {
        super(itemView);
        cv = itemView.findViewById(R.id.cv);
        foodName = (TextView)itemView.findViewById(R.id.food_name);
        foodDetails = (TextView)itemView.findViewById(R.id.food_details);
        foodPhoto = (ImageView)itemView.findViewById(R.id.food_photo);
    }
}
