package com.example.a2022realproject_pmplusapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity_Success extends AppCompatActivity {

    Button gomain;
    Button goLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_success);

        gomain = (Button)findViewById(R.id.btn_goMain);
        goLogin =(Button)findViewById(R.id.btn_goLogin);

        gomain.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity_PM_Main.class); //나중에 작성 할 PM 메인화면 넣으면 됨
            startActivity(intent);

        }); //람다식(익명함수)으로 작성, 회원가입 버튼 클릭 시 성공 화면으로 이동

        goLogin.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity_Login.class);
            startActivity(intent);
        });



    }
}