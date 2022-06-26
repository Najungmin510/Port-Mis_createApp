package com.example.a2022realproject_pmplusapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.content.Intent;


public class MainActivity_Login extends AppCompatActivity {
    Button MemberConversion;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        MemberConversion = (Button)findViewById(R.id.btn_register);
        Login = (Button)findViewById(R.id.btn_Login);


        MemberConversion.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), MainActivity_Membership.class);
            startActivity(intent);

        }); //람다식(익명함수)으로 작성, 회원가입 버튼 클릭 시  화면 전환


    }
}