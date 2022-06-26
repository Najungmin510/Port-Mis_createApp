package com.example.a2022realproject_pmplusapp;

import android.icu.util.Output;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;

import org.json.JSONException; //json형식으로 데이터를 보내기 위해 선언
import org.json.JSONObject; //이하동일
import java.net.URISyntaxException;


import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;



public class ServerConnect{
    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("http://192.168.219.150:3000");
            mSocket.connect(); //연결

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public void start(EditText id, EditText pw, EditText name, EditText mail){

            JSONObject data = new JSONObject();

            try{

                data.put("user_id",id); //데이터 전송
                data.put("user_pw",pw);
                data.put("user_name",name);
                data.put("user_mail",mail);
                mSocket.emit("MembershipSign",data); //서버랑 이벤트 명이 같아야 에러 안남

            }catch(JSONException e){
                e. printStackTrace();
            }


    }

}






