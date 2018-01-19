package com.example.administrator.servicedemo;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    private SsoAuth mSsoAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.bt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSsoAuth == null) {
                    bindSsoAuthService();
                } else {
                    doLogin();
                }
            }
        });
    }

    private void bindSsoAuthService() {
        Intent intent = new Intent("com.example.administrator.servicedemo");
        intent.setPackage(getPackageName());
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }

    ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            mSsoAuth = SsoAuth.Stub.asInterface(iBinder);
            doLogin();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            mSsoAuth = null;
        }
    };

    public void doLogin() {
        try {
            mSsoAuth.ssoAuth("mr.ss", "123456");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }
}
