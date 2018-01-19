package com.example.administrator.servicedemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * author: wangnannan
 * date: 2018/1/19 16:01
 * desc: TODO
 * 广播接收器
 */

public class HelloBroadcastReceiver extends BroadcastReceiver {
    private final static String TAG = HelloBroadcastReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
    }
}
