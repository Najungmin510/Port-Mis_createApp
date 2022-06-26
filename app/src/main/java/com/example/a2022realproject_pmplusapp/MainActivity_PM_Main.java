package com.example.a2022realproject_pmplusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


public class MainActivity_PM_Main extends AppCompatActivity {

    Button shipdata;
    Button Mshipdata;
    Button Weatherdata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pm_main);

        Toolbar myToolbar = (Toolbar)findViewById(R.id.PMToolbar);
        setSupportActionBar(myToolbar);


        shipdata = (Button)findViewById(R.id.btn_shipfind);
        Mshipdata = (Button)findViewById(R.id.btn_MshipFind);
        Weatherdata = (Button)findViewById(R.id.btn_Weather);

        shipdata.setOnClickListener(v -> {
             Intent intent = new Intent(getApplicationContext(), MainActivity_ShipData.class);
             startActivity(intent);

        }); //선박입출항조회 화면으로 넘어감

        Mshipdata.setOnClickListener(v ->{
            Intent intent = new Intent(getApplicationContext(),MainActivity_MshipData.class);
            startActivity(intent);

        }); //선별관제현황

        Weatherdata.setOnClickListener(v ->{

            Intent intent = new Intent(getApplicationContext(),MainActivity_Weather.class);
            startActivity(intent);

        }); //날씨


    }



    private void setSupportActionBar(Toolbar myToolbar) {

    }
}