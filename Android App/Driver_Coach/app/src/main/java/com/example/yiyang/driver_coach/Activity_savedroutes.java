package com.example.yiyang.driver_coach;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Activity_savedroutes extends AppCompatActivity implements View.OnClickListener{

    Button btn_drive_home, btn_drive_to_lehigh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_routes);

        btn_drive_home = (Button) findViewById(R.id.btn_drive_home);
        btn_drive_home.setOnClickListener(this);

        btn_drive_to_lehigh = (Button) findViewById(R.id.btn_drive_to_lehigh);
        btn_drive_to_lehigh.setOnClickListener(this);


//        btn_drive_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////              Toast.makeText(Activity_main.this, "You press new drive button", Toast.LENGTH_LONG).show();
//                Intent intent = new Intent(Activity_savedroutes.this, Activity_showmap.class);
//
//                intent.putExtra("now_route", btn_drive_home.getText().toString());
//                startActivity(intent);
//            }
//        });
//
    }
    //Intent intent = new Intent(Activity_main.this, Activity_map.class);
    //startActivity(intent);

    @Override
    public void onClick(View view) {

        Button now_button = (Button)view;
        String csv_path = "";
        if (now_button.getText().toString().compareTo("Drive Home")==0) {
            csv_path = "/storage/emulated/legacy/xincoder/data_2017-10-22_12_48_11.csv";
        }
        else {
            csv_path = "/storage/emulated/legacy/xincoder/data_2017-10-22_12_48_11.csv";
        }

        Intent intent = new Intent(Activity_savedroutes.this, Activity_map.class);
        intent.putExtra("now_route", now_button.getText().toString());
        intent.putExtra("csv_path", csv_path);
        startActivity(intent);
    }
}
