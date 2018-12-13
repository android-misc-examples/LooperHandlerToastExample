package com.example.pgp.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Thread t;
    public static MainActivity mainActivity;

    public final Handler h = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == WorkerThread.HTAG) {
                Log.e("handleMessage", "Received toastmessage");
                Toast.makeText(MainActivity.this,"[on handler] Count: "+msg.obj,Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = this;
        setContentView(R.layout.activity_main);

        t = new ErrorThread(); // exception, tries to call Toast.makeText directly
//        t = new CustomThread(this); // with runOnUiThread
        t = new WorkerThread(h); // with Looper/Handler
        t.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        t.interrupt();
        mainActivity = null;
    }
}
