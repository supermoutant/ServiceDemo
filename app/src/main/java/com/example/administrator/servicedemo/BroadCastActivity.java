package com.example.administrator.servicedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class BroadCastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_cast);
        Intent intent = new Intent(this, HelloBroadcastReceiver.class);
        sendBroadcast(intent);
    }
}
