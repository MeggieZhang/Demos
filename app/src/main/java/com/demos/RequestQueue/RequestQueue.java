package com.demos.RequestQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by Mr_Wrong on 16/3/4.
 */
public abstract class RequestQueue<T> {

    private BlockingQueue<T> mRequestQueue = new PriorityBlockingQueue<T>();

    public void add(T t) {
        mRequestQueue.add(t);
    }

    public void start() {
        Executor<T> executor = new Executor<>(mRequestQueue,this);
        executor.start();
    }

    public abstract void handleResult(T t);



}
