package com.example.ubuntu.threadpooltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Runnable command = new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        };

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(4);
        fixedThreadPool.execute(command);

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(command);


    }
}
