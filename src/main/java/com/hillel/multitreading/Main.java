package com.hillel.multitreading;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {

        way6(); // last example

        way5();
        way6();
        way4();
        way3();
        way3();
        way2();
        way1();
    }

    private static void way6() {
        Runnable myStoppabeTask1 = () -> {

            while (!Thread.currentThread().isInterrupted()) {
                System.out.printf("<%d> \t  \n",
                        new Random().nextInt(10));
                Thread.yield();
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    System.out.println("Exception was detected");
                    Thread.currentThread().interrupt();
                }
            }

        };

        Thread t = new Thread(myStoppabeTask1);
        t.start();
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        t.interrupt();
    }

    private static void way5() {
        MyStoppableThread tStoppable = new MyStoppableThread();
        tStoppable.setPriority(1);
        tStoppable.start();
        new Scanner(System.in).nextLine();


        tStoppable.pleaseStop();

        System.out.println("Finishing the Main thread");
    }


    private static void way4() {
        Runnable myTask = () -> {
            for (int i = 0; i < 7; i++) {
                System.out.printf("%s :: %d \n", Thread.currentThread().getName(), i);
            }
        };

        Thread tLow = new Thread(myTask);
        Thread tMiddle = new Thread(myTask);
        Thread tHigh = new Thread(myTask);

        tLow.setPriority(1);
        tMiddle.setPriority(5);
        tHigh.setPriority(10);

        tLow.start();
        tMiddle.start();
        tHigh.start();
    }

    private static void way3() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 30; i++) {
                    System.out.println(
                            Thread.currentThread().getName() + " :: " + i);
                    Thread.yield();
                }
            }
        });

        Thread t2 = new Thread(new Task1());
        Thread t3 = new Thread(new Task1());

        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.start();
        t3.start();
    }

    private static void way2() {
        Task1 task = new Task1();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(task);
            String name = String.format("T[%d]", i);
            t.setName(name);
            t.start();
        }
    }

    private static void way1() {
        Thread myThread1 = new MyThread();
        Thread myThread2 = new MyThread();

        System.out.println("Starting thread 1:");
        myThread1.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
        System.out.println("Starting thread 2:");
        myThread2.start();
    }
}
