package com.example.pgp.myapplication;

import android.app.Activity;
import android.widget.Toast;

public class CustomThread extends Thread {

    private final Activity activity;

    private int count = 0;

    public CustomThread(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void run() {
        for(;;) {
            activity.runOnUiThread(()-> Toast.makeText(activity,"count: "+count++,Toast.LENGTH_SHORT).show());
            try {
                Thread.sleep(5000);
            }
            catch (InterruptedException e) {
                activity.runOnUiThread(()-> Toast.makeText(activity,"Interrupted",Toast.LENGTH_SHORT).show());
                return;
            }
        }
    }
}
