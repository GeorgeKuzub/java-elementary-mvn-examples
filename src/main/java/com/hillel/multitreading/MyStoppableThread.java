package com.hillel.multitreading;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyStoppableThread extends Thread {
    private boolean stop = false;

    @Override
    public void run() {
        while (!stop) {
            System.out.printf("<%d> \t  \n",
                    new Random().nextInt(10));

            try {
//                Thread.currentThread().sleep(2000);
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public void pleaseStop() {
        // close all opened resources
        stop = true;
    }

}
