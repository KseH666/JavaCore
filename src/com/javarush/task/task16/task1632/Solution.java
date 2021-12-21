package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread1 th = new Thread1();
        threads.add(th);
        Thread2 th2 = new Thread2();
        threads.add(th2);
        Thread3 th3 = new Thread3();
        threads.add(th3);
        Thread4 th4 = new Thread4();
        threads.add(th4);
        th4.showWarning();
        Thread5 th5 = new Thread5();
        threads.add(th5);

    }

    public static void main(String[] args) {
        for (Thread thread : threads) {
            thread.start();
        }


    }


    public static class Thread5 extends Thread {
        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String a = "";
            int b = 0;
            for (; ; ) {
                try {
                    a = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (a.equals("N")) {
                    System.out.println(b);
                    break;
                } else {
                    b = Integer.parseInt(a) + b;
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {

        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
            }

        }

        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            for (; ; ) {
                try {
                    System.out.println("Ура");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class Thread2 extends Thread {
        public void run() {
            try {
                interrupt();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }


    public static class Thread1 extends Thread {
        public void run() {
            for (; ; ) {
            }
        }
    }
}