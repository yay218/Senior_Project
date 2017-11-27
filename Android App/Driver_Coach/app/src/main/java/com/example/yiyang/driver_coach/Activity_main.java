package com.example.yiyang.driver_coach;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class Activity_main extends AppCompatActivity {

    Button btn_new_drive, btn_history_route;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_new_drive = (Button) findViewById(R.id.btn_new_drive);
        btn_history_route = (Button) findViewById(R.id.btn_history_route);

        btn_new_drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast.makeText(Activity_main.this, "You press new drive button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_main.this, Activity_newdrive.class);
                startActivity(intent);
            }
        });

        btn_history_route.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(Activity_main.this, "You press history button", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Activity_main.this, Activity_savedroutes.class);
                startActivity(intent);
                //Intent intent = new Intent(Activity_main.this, Activity_map.class);
                //startActivity(intent);
            }
        });

//        try {
//            String sd_path = Environment.getExternalStorageDirectory().getAbsolutePath();
//            readFileData("/storage/emulated/legacy/xincoder/data_2017-10-22_12_48_11.csv");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
