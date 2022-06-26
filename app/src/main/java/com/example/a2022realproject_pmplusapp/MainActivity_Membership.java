package com.example.a2022realproject_pmplusapp;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Button; //버튼도 동일함
import android.widget.Toast; //토스트 메세지를 이용하여, 회원가입이 완료되었습니다 메세지를 출력

import org.json.JSONException; //json형식으로 데이터를 보내기 위해 선언
import org.json.JSONObject; //이하동일

import java.net.URISyntaxException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.socket.client.IO; //socket을 사용해주기 위해 선언
//import io.socket.client.Socket; //이하동일

import java.net.ServerSocket;
import java.net.Socket;

/*
순서

사용자 입력 값 받아오기 -> 서버 연결 -> 만약 입력하지 않은채로 버튼을 누르면 토스트 메세지 출력 ->
전부 입력했다면 회원가입 버튼 클릭시 이 데이터를 서버로 전송 -> 전송 완료 시 회원가입 성공이라는 토스트 메세지 출력
->로그인창으로 화면 전환

 */


public class MainActivity_Membership extends AppCompatActivity {

     EditText userid; //아이디 입력받은 것 저장할 변수
     EditText userpass; //비밀번호 입력받은 것 저장할 변수
     EditText username; //사용자 이름 입력받은 것 저장할 변수
     EditText useremail; //사용자 이메일 입력받은 것 저장할 변수
     Button MemberShipBtn; //버튼 값을 저장할 변수


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_membership);


        MemberShipBtn =(Button)findViewById(R.id.btn_member); //버튼값도 불러와 할당해줌

        userid = (EditText)findViewById(R.id.et_id); //각 아이디(각 데이터가 가지는 고유값)를 찾아서 et_id에 연결해줌
        userid.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) }); //아이디 글자수 제한
        userid.getText().toString();


        userpass = (EditText)findViewById(R.id.et_pass); //이하 동일
        userpass.setFilters(new InputFilter[] { new InputFilter.LengthFilter(20) }); //비밀번호 글자수수 제한
        userpass.getText().toString(); //글자를 가져옴


        username= (EditText)findViewById(R.id.et_name);
        username.setFilters(new InputFilter[] { new InputFilter.LengthFilter(5) }); //이름은 최대 5글자
        username.getText().toString();




        useremail = (EditText)findViewById(R.id.et_email);
        useremail.getText().toString();


        useremail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if(!android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()){
                    Toast.makeText(getApplicationContext(),"이메일 형식에 맞춰주세요.",Toast.LENGTH_SHORT).show();
                }
                else{

                    MemberShipBtn.setOnClickListener(v -> { //버튼이 눌렸을 때

                        ServerConnect thread = new ServerConnect();
                        thread.start(userid, userpass, username, useremail); //작성한 자료들을 서버로 보내기 위해 SERVER CONNECT로 데이터 넘겨줌

                        Intent intent = new Intent(getApplicationContext(), MainActivity_Success.class);
                        startActivity(intent);

                    }); //람다식(익명함수)으로 작성, 회원가입 버튼 클릭 시 성공 화면으로 이동


                }
            }// afterTextChanged()..
        });



    }

}

