package com.manhthong.chatsocketio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class LoginActivity extends AppCompatActivity {
    TextView tvSignUp;
    Button btnSignIn;
    private Socket mSocket;
    {
        try {
            mSocket = IO.socket("http://192.168.145.2:3000");
        } catch (URISyntaxException e) {}
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mSocket.connect();
        setContentView(R.layout.login_activity);
        tvSignUp=findViewById(R.id.tvSignUp);
        btnSignIn=findViewById(R.id.btnSignIn);
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp= new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intentSignUp);
            }
        });
        //set su kien cho btnSignIn
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp= new Intent(LoginActivity.this, MainActivity.class);
                finish();
                startActivity(intentSignUp);
            }
        });


    }
    public Socket  get_mSocket(){
        return mSocket;
    }
}