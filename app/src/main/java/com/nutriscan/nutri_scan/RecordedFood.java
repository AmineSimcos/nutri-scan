package com.nutriscan.nutri_scan;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RecordedFood extends AppCompatActivity {
    private RecyclerView rv;
    private List<Food> foodItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recorded_food);

        rv = findViewById(R.id.food_recycler_view);
        rv.setHasFixedSize(true);

        LinearLayoutManager llm = new LinearLayoutManager(rv.getContext());
        rv.setLayoutManager(llm);

        initializeData(); // To populate foodItems

        rv.setAdapter(new RVAdapter(foodItems));
    }




    // TODO: use real stored data, not static ones.
    private void initializeData() {
        foodItems = new ArrayList<>();


        HashMap<String, Integer> stats = new HashMap<>();

        stats.put("calories", 1);
        stats.put("addedSugar", 1);
        stats.put("otherSugar", 1);
        stats.put("carbs", 1);
        stats.put("protein", 1);
        stats.put("transFat", 1);
        stats.put("saturatedFat", 1);
        stats.put("otherFat", 1);


        foodItems.add(new Food("Emma Wilson", stats, 1));
    }
}

