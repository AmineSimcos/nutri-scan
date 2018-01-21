package com.nutriscan.nutri_scan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class FoodClick extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_click);
    }

    ImageView myImageView = (ImageView) findViewById(R.id.myImageView);
    myImageView.setImageResource(R.drawable.android_background);

}
