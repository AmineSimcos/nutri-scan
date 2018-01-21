package com.nutriscan.nutri_scan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecordedFood extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorded_food);

        RecyclerView rv = (RecyclerView)findViewById(R.id.food_recycler_view);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);
    }
}
