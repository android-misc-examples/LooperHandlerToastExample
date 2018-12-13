package com.example.pgp.myapplication;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class WorkerThread extends Thread {

    public static final int HTAG = 1234567890;
    private final Handler h;
    private int count = 0;

    public WorkerThread(Handler h) {
        this.h = h;
    }

    @Override
    public void run() {
        for(;;) {
            Message m = new Message();
            m.obj = count;
            m.what = HTAG;
            h.sendMessage(m);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                Log.e(getClass().getName(),"Interrupted");
                return;
            }
            count++;
        }
    }
}
