package com.example.administrator.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * author: wangnannan
 * date: 2018/1/19 14:43
 * desc: TODO
 */

public class SinaSsoAuthService extends Service {
    private final static String TAG = SinaSsoAuthService.class.getSimpleName();
    SinaSsoImpl mBinder = new SinaSsoImpl();

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "sso create ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

    class SinaSsoImpl extends SsoAuth.Stub {

        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void ssoAuth(String userName, String pwd) throws RemoteException {
            Log.e(TAG, "登录名称" + userName + "登录密码~~~~" + pwd);
        }
    }
}
