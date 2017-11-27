package com.example.yiyang.driver_coach;

import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Activity_map extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    Button btn_drive_again, btn_main_menu, btn_get_feedback;
    TextView text_now_route;
    String csv_file = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle extras = getIntent().getExtras();
        String now_route = extras.getString("now_route");
        csv_file = extras.getString("csv_path");
        text_now_route = (TextView) findViewById(R.id.text_now_route);
        text_now_route.setText(now_route);




        btn_drive_again = (Button) findViewById(R.id.btn_drive_again);
        btn_main_menu = (Button) findViewById(R.id.btn_main_menu);
        btn_get_feedback = (Button) findViewById(R.id.btn_get_feedback);

        btn_drive_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_map.this, Activity_newdrive.class);
                startActivity(intent);
            }
        });

        btn_main_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_map.this, Activity_main.class);
                startActivity(intent);
            }
        });

        btn_get_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_map.this, Activity_feedback.class);
                startActivity(intent);
            }
        });


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.getUiSettings().setZoomControlsEnabled(true);

//        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        try {
            List<LatLng> location_list = readFileData(csv_file);

            if (location_list.size()>0) {

                for(int i = 0; i<location_list.size()-1; i++){
                    mMap.addPolyline(new PolylineOptions()
                            .add(location_list.get(i), location_list.get(i+1))
                            .width(5)
                            .color(Color.RED));
                }
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location_list.get(location_list.size()/2), 16));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    List<LatLng> readFileData(String path) throws FileNotFoundException
    {
        String[] data;
        File file = new File(path);
        List<LatLng> location_list = new LinkedList<>();
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            try {
                String csvLine;
                if ((br.readLine()) != null) {
                    while ((csvLine = br.readLine()) != null){
                        data=csvLine.split(",");
                        float now_lon = Float.parseFloat(data[7].toString());
                        float now_lat = Float.parseFloat(data[8].toString());
                        LatLng now_location = new LatLng(now_lat, now_lon);
                        location_list.add(now_location);
                    }
                }
            }
            catch (IOException ex)
            {
                throw new RuntimeException("Error in reading CSV file: "+ex);
            }
        }
        else
        {
            Toast.makeText(getApplicationContext(),"file not exists",Toast.LENGTH_SHORT).show();
        }
        return location_list;
    }
}
