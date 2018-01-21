package com.nutriscan.nutri_scan;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AnimatedPieChart extends AppCompatActivity {

    private static String TAG = "PieChart";
    private int totalCal = 10;
    private int newCal = 5;
    public void setCals(int tc, int nc) {
        totalCal = tc;
        newCal = nc;
    }

    /*
    // Input from current calories intake for today
    TextView num1 = (TextView)findViewById(R.id.num1);
    String totalCalories= num1.getText().toString();
    int totalCal=Integer.parseInt(totalCalories);

    // Input for new calories to be added
    TextView num2 = (TextView)findViewById(R.id.num2);
    String newCalories= num2.getText().toString();
    int newCal=Integer.parseInt(newCalories);
    */

    // Total of new consumption of calories
    int newTotalCal;

    //displays new total calories now being consumed
    TextView displayTotalCal;

    private int[] yData = {totalCal, newCal};
    private String[] xData = {"Total Calories before meal", "Meal to be added"};
    PieChart pieChart;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //displays the total calories consumption
        displayCalories(totalCal,newCal);
        //calculates calories consumption
        totalCalories(totalCal,newCal);


        displayTotalCal = (TextView)findViewById(R.id.newTotalCal);

        setContentView(R.layout.activity_animated_pie_chart);

        Log.d(TAG, "onCreate: starting to create chart");



        pieChart = (PieChart) findViewById(R.id.idPieChart);

        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(25f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Total calories consumption");

        addDataSet();

    }
    void displayCalories(int currentCal, int newCal){

        //output print for the new total consumption underneath the pie chart
        displayTotalCal.setText("The total calories of consumption is now: " + totalCalories(currentCal,newCal));

    }

    int totalCalories(int currentCal, int newCal){
        //adds the current calories and new calories together to get the new total calories consumption
        newTotalCal = currentCal + newCal;
        return newTotalCal;

    }


    private void addDataSet(){
        Log.d(TAG, "addDataSet started");
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        ArrayList<String> xEntrys = new ArrayList<>();

        for(int i = 0; i < yData.length; i++){
            yEntrys.add(new PieEntry(yData[i], i));

        }

        for(int i = 1; i < xData.length; i++){
            xEntrys.add(xData[i]);
        }

        //creates data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "Calories consumption");
        pieDataSet.setSliceSpace(2);
        pieDataSet.setValueTextSize(12);

        //add colors to distinguish different type of calories consumption
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.LTGRAY);
        colors.add(Color.CYAN);

        pieDataSet.setColors(colors);


        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();


    }



}
