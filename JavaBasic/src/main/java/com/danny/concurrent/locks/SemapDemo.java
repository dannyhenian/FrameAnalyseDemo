package com.danny.concurrent.locks;/**
 * Created by danny on 2018-01-12.
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author danny
 * @create 2018-01-12 17:50
 */

public class SemapDemo implements Runnable {
    final Semaphore semp = new Semaphore(5);

    public void run() {
        try {
            semp.acquire();
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getId()+" :done!");
            semp.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        ExecutorService exec = Executors.newFixedThreadPool(20);
        final SemapDemo demo = new SemapDemo();
        for (int i=0;i<20;i++){
            exec.submit(demo);
        }

}



}
