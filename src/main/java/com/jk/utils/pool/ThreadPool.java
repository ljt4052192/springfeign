package com.jk.utils.pool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {

    private static ExecutorService fixedThreadPool  =  Executors.newFixedThreadPool(10);

    public static void executor(Runnable runnable){
        fixedThreadPool.execute(runnable);

    }

}
