package com.example.yiyang.driver_coach;

import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Activity_feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        // HorizontalBarChart barChart= (HorizontalBarChart) findViewById(R.id.chart);

        ArrayList<BarEntry> entries1 = new ArrayList<>();
        entries1.add(new BarEntry(38, 0));
        entries1.add(new BarEntry(37, 1));
        entries1.add(new BarEntry(22, 2));
        entries1.add(new BarEntry(22, 3));
        entries1.add(new BarEntry(23, 4));
//        entries1.add(new BarEntry(38, 0));
//        entries1.add(new BarEntry(37, 1));
//        entries1.add(new BarEntry(22, 2));
//        entries1.add(new BarEntry(22, 3));
//        entries1.add(new BarEntry(23, 4));
        BarDataSet dataset1 = new BarDataSet(entries1, "Heavy/Light Traffic");
        //dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarEntry> entries2 = new ArrayList<>();
        entries2.add(new BarEntry(58, 0));
        entries2.add(new BarEntry(56, 1));
        entries2.add(new BarEntry(30, 2));
        entries2.add(new BarEntry(38, 3));
        entries2.add(new BarEntry(31, 4));
        BarDataSet dataset2 = new BarDataSet(entries2, "Heavy/Light Traffic");


        ArrayList<BarEntry> entries3 = new ArrayList<>();
        entries3.add(new BarEntry(3, 0));
        entries3.add(new BarEntry(4, 1));
        entries3.add(new BarEntry(0, 2));
        entries3.add(new BarEntry(0, 3));
        entries3.add(new BarEntry(1, 4));
        BarDataSet dataset3 = new BarDataSet(entries3, "Heavy/Light Traffic");




        ArrayList<String> labels = new ArrayList<String>();
        labels.add("Oct11");
        labels.add("Oct16");
        labels.add("Oct19");
        labels.add("Oct20");
        labels.add("Oct27");
        //labels.add("Oct11");

        /*
        // for create Grouped Bar chart
        ArrayList<BarEntry> group1 = new ArrayList<>();
        group1.add(new BarEntry(4f, 0));
        group1.add(new BarEntry(8f, 1));
        group1.add(new BarEntry(6f, 2));
        group1.add(new BarEntry(12f, 3));
        group1.add(new BarEntry(18f, 4));
        group1.add(new BarEntry(9f, 5));

        ArrayList<BarEntry> group2 = new ArrayList<>();
        group2.add(new BarEntry(6f, 0));
        group2.add(new BarEntry(7f, 1));
        group2.add(new BarEntry(8f, 2));
        group2.add(new BarEntry(12f, 3));
        group2.add(new BarEntry(15f, 4));
        group2.add(new BarEntry(10f, 5));

        BarDataSet barDataSet1 = new BarDataSet(entries1, "Group 1");
        barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(ColorTemplate.COLORFUL_COLORS);

        BarDataSet barDataSet2 = new BarDataSet(group2, "Group 2");
        barDataSet2.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<BarDataSet> dataset = new ArrayList<>();
        dataset.add(barDataSet1);
        dataset.add(barDataSet2);
*/

        BarData data1 = new BarData(labels, dataset1);
        BarChart barChart_1 = (BarChart) findViewById(R.id.chart_1);
        dataset1.setColors(new int[] {Color.RED, Color.RED, Color.BLUE, Color.BLUE, Color.BLUE});
        XAxis xAxis1 = barChart_1.getXAxis();
        xAxis1.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart_1.setData(data1);
        barChart_1.animateY(5000);



        BarData data2 = new BarData(labels, dataset2);
        BarChart barChart_2 = (BarChart) findViewById(R.id.chart_2);
        dataset2.setColors(new int[] {Color.argb(255, 253, 143, 157), Color.argb(255, 253, 143, 157), Color.argb(255, 145, 235, 254), Color.argb(255, 145, 235, 254), Color.argb(255, 145, 235, 254)});
        XAxis xAxis2 = barChart_2.getXAxis();
        xAxis2.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart_2.setData(data2);
        barChart_2.animateY(5000);


        BarData data3 = new BarData(labels, dataset3);
        BarChart barChart_3 = (BarChart) findViewById(R.id.chart_3);
        dataset3.setColors(new int[] {Color.argb(255, 253, 143, 157), Color.argb(255, 253, 143, 157), Color.argb(255, 145, 235, 254), Color.argb(255, 145, 235, 254), Color.argb(255, 145, 235, 254)});
        XAxis xAxis3 = barChart_3.getXAxis();
        xAxis3.setPosition(XAxis.XAxisPosition.BOTTOM);
        barChart_3.setData(data3);
        barChart_3.animateY(5000);
    }
}
