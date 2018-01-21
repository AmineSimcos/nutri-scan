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

        Context context = rv.getContext();

        LinearLayoutManager llm = new LinearLayoutManager(context);
        rv.setLayoutManager(llm);

        initializeData(); // To populate foodItems

        rv.setAdapter(new RVAdapter(foodItems, context));
    }




    // TODO: use real stored data, not static ones.
    private void initializeData() {
        foodItems = new ArrayList<>();


        HashMap<String, Integer> stats1 = new HashMap<>();
        HashMap<String, Integer> stats2 = new HashMap<>();
        HashMap<String, Integer> stats3 = new HashMap<>();

        stats1.put("calories", 1);
        stats1.put("addedSugar", 1);
        stats1.put("otherSugar", 1);
        stats1.put("carbs", 1);
        stats1.put("protein", 1);
        stats1.put("transFat", 1);
        stats1.put("saturatedFat", 1);
        stats1.put("otherFat", 1);

        stats2.put("calories", 2);
        stats2.put("addedSugar", 1);
        stats2.put("otherSugar", 1);
        stats2.put("carbs", 1);
        stats2.put("protein", 1);
        stats2.put("transFat", 1);
        stats2.put("saturatedFat", 1);
        stats2.put("otherFat", 1);

        stats3.put("calories", 3);
        stats3.put("addedSugar", 1);
        stats3.put("otherSugar", 1);
        stats3.put("carbs", 1);
        stats3.put("protein", 1);
        stats3.put("transFat", 1);
        stats3.put("saturatedFat", 1);
        stats3.put("otherFat", 1);


        foodItems.add(new Food("FOOD", stats1, 1));
        foodItems.add(new Food("Apple", stats2, 1));
        foodItems.add(new Food("Yay", stats3, 1));
    }
}

