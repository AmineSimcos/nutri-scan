package com.nutriscan.nutri_scan;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by emilyzhong on 1/21/18.
 */

class Food {
    String name;
    /* calories, addedSugar, otherSugar, carbs, protein, transFat, saturatedFat, otherFat*/
    Map<String, Integer> stats;
    int photoId;

    Food(String n, Map s, int p) {
        name = n;
        stats = s;
        photoId = p;
    }
}