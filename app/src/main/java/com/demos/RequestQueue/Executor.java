package com.demos.RequestQueue;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Mr_Wrong on 16/3/4.
 */
public class Executor<T> extends Thread {
    T request;
    BlockingQueue mQueue;
    RequestQueue requestQueue;
    Handler mHandler = new Handler(Looper.getMainLooper());

    public Executor(BlockingQueue<T> queue, RequestQueue requestQueue) {
        this.mQueue = queue;
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                request = (T) mQueue.take();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        requestQueue.handleResult(request);
                    }
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
