package com.nutriscan.nutri_scan;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: complete this.
                Snackbar.make(view, "Add ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // TODO: Replace fillers.
        int caloriesConsumed = 400;
        int caloriesLeft = 1600;

        int regularCarbs = 200;
        int naturalSugars = 100;
        int addedSugars = 50;
        int carbsLeft = 20;

        int protein = 300;
        int proteinLeft = 400;

        int transFat = 20;
        int saturatedFat = 10;
        int otherFats = 30;
        int fatsLeft = 5;

        WebView webview = (WebView) findViewById(R.id.webView1);
        String content = "<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
                + "    <script type=\"text/javascript\">"
                + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
                + "      google.setOnLoadCallback(drawCharts);"

                + "      function drawCharts() {"
                + "         drawPieChart(); drawBarCharts(); }"

                + "      function drawPieChart() {"
                + "        var data = google.visualization.arrayToDataTable(["
                + "          ['Category', 'Calories'], "
                + "          ['Calories Consumed'," + caloriesConsumed + "],"
                + "          ['Calories Left'," + caloriesLeft + "]"
                + "        ]);"
                + "        var options = {"
                + "          pieHole: 0.6,"
                + "          reverseCategories: true,"
                + "          slices: [{color: '#cccccc'}, {color: 'green'}],"
                + "          legend: 'none',"
                + "          chartArea: {width: '100%', height: '100%'},"
                + "          pieSliceText: 'value',"
                + "        };"
                + "        var chart = new google.visualization.PieChart(document.getElementById('calories_pie'));"
                + "        chart.draw(data, options);"
                + "      }"

                + "     function drawBarCharts() {" +
                "           var options = {" +
                "               isStacked: 'percent'," +
                "               vAxis: {" +
//                "                   gridlines: {color: 'transparent'}," +
//                "                   textPosition: 'none'," +
                "                       count: 2" +
                "               }," +
                "               hAxis: {" +
                "                   gridlines: {color: 'transparent'}," +
                "                   baseline: {color: 'transparent'}," +
                "                   textPosition: 'none'" +
                "               }," +
                "               legend: {position: 'top', maxLines: 1}," +
                "               chartArea: {width: '100%', height: '50%'}" +
                "            };" +

                "           var carbsData = google.visualization.arrayToDataTable([" +
                "               ['', 'Regular', 'Natural Sugars', 'Added Sugars', 'Remaining', ], " +
                "               [''," + regularCarbs + "," + naturalSugars + "," + addedSugars + "," + carbsLeft + "]" +
                "           ]);" +

                "           var proteinData = google.visualization.arrayToDataTable([" +
                "               ['', 'Consumed', 'Remaining'], " +
                "               [''," + protein + "," + proteinLeft + "]" +
                "           ]);" +

                "           var fatsData = google.visualization.arrayToDataTable([" +
                "               ['', 'Trans Fat', 'Saturated Fat', 'Other', 'Remaining', ], " +
                "               [''," + transFat + "," + saturatedFat + "," + otherFats + "," + fatsLeft + "]" +
                "           ]);" +

                "           var carbsChart = new google.visualization.BarChart(document.getElementById('carbs'));" +
                "           carbsChart.draw(carbsData, options);" +

                "           var proteinChart = new google.visualization.BarChart(document.getElementById('protein'));" +
                "           proteinChart.draw(proteinData, options);" +

                "           var fatsChart = new google.visualization.BarChart(document.getElementById('fats'));" +
                "           fatsChart.draw(fatsData, options);" +
                "       }"
                + "    </script>"
                + "  </head>"
                + "  <body>" +
                "       <style>" +
                "           h3 { margin-top: 10vh;}" +
                "       </style>"
                + "    <h3 style=\"text-align: center\">Today's Caloric Consumption</h3>"
                + "    <div id=\"calories_pie\"></div>"

                + "    <h3 style=\"text-align: center\">Carbohydrate Consumption</h3>"
                + "    <div id=\"carbs\"></div>"

                + "    <h3 style=\"text-align: center\">Protein Consumption</h3>"
                + "    <div id=\"protein\"></div>"

                + "    <h3 style=\"text-align: center\">Fat Consumption</h3>"
                + "    <div id=\"fats\"></div>"
                + "  </body>" + "</html>";

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();
        webview.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);

    }
}
