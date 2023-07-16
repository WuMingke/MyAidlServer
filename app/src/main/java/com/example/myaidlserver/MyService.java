package com.example.myaidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyService extends Service {

    private User user;

    @Override
    public void onCreate() {
        super.onCreate();
        user = new User("mingke");
        Log.i("wmkwmk", "service onCreate");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("wmkwmk", "service onBind");
        return new MyBinder();
    }

    static class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public String getName() throws RemoteException {
            Log.i("wmkwmk", "MyBinder getName");
            return "test";
        }

        @Override
        public User getUserName(String data) throws RemoteException {
            Log.i("wmkwmk", "MyBinder getUserName");
            return new User("123");
        }
    }

}
