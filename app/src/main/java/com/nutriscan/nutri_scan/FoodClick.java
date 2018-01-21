package com.nutriscan.nutri_scan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FoodClick extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodclick);


        ImageView myImageView = (ImageView) findViewById(R.id.imageView);
        myImageView.setImageResource(R.drawable.ic_launcher_background);

       button = findViewById(R.id.button);
       button.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                openAnimatedPieChart();

            }
        });

    }

    public void openAnimatedPieChart(){
        Intent intent = new Intent(this, AnimatedPieChart.class);
        startActivity(intent);

    }


}