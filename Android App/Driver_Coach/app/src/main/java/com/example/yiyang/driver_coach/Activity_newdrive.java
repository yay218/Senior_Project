package com.example.yiyang.driver_coach;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;

public class Activity_newdrive extends AppCompatActivity {
    Button btn_startStopDriving;
    TextView text_analyze;
    EditText text_route1;
    private Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newdrive);
        btn_startStopDriving = (Button) findViewById(R.id.btn_startStopDriving);
        text_analyze = (TextView) findViewById(R.id.text_analyze);
        text_route1 = (EditText) findViewById(R.id.text_route1);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        //((Button) findViewById(R.id.btn_startStopDriving)).setOnClickListener(this);
        //((Button) findViewById(R.id.stop_button)).setOnClickListener(this);



        btn_startStopDriving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//              Toast.makeText(Activity_main.this, "You press new drive button", Toast.LENGTH_LONG).show();
                if(btn_startStopDriving.getText().toString().equals("Start Driving")){

                    Intent intent = new Intent(Activity_newdrive.this, Activity_map.class);
                    intent.putExtra("now_route", text_route1.getText().toString());
//                    intent.putExtra("now_route", text_route1.getText().toString());

                    String csv_path = "/storage/emulated/legacy/xincoder/data_now.csv";

                    intent.putExtra("csv_path", csv_path);

                    startActivity(intent);

                    text_analyze.setVisibility(View.INVISIBLE);
                    chronometer.stop();

                }
                else {
                    text_analyze.setVisibility(View.VISIBLE);
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();

                }

            }
        });



    }
}
