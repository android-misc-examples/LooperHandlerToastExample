package com.example.pgp.myapplication;

import android.widget.Toast;

public class ErrorThread extends Thread {

    private int count = 0;

    @Override
    public void run() {
        for(;;) {
            Toast.makeText(MainActivity.mainActivity,"count: "+count++,Toast.LENGTH_SHORT).show();
            try { Thread.sleep(5000); }
            catch (InterruptedException e) { return; }
        }
    }
}
