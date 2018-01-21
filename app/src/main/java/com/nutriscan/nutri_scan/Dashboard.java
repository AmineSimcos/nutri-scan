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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        int caloriesConsumed = 400;
        int caloriesLeft = 1600;

        WebView webview = (WebView) findViewById(R.id.webView1);
        String content = "<html>"
                + "  <head>"
                + "    <script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>"
                + "    <script type=\"text/javascript\">"
                + "      google.load(\"visualization\", \"1\", {packages:[\"corechart\"]});"
                + "      google.setOnLoadCallback(drawChart);"
                + "      function drawChart() {"
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
                + "    </script>"
                + "  </head>"
                + "  <body>"
                + "    <h3 style=\"text-align: center\">Today's Caloric Consumption</h3>"
                + "    <div id=\"calories_pie\"></div>"
                + "  </body>" + "</html>";

        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webview.requestFocusFromTouch();
        webview.loadDataWithBaseURL("file:///android_asset/", content, "text/html", "utf-8", null);

    }
}
