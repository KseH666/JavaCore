package com.javarush.task.task16.task1623;

/* 
Рекурсивное создание нитей
*/

public class Solution {
    static int count = 15;
    static volatile int createdThreadCount;

    public static void main(String[] args) {
        new GenerateThread();
    }

    public static class GenerateThread extends Thread {

        public void run() {
            if (createdThreadCount < count) {
                System.out.println(new GenerateThread());
            }
        }

        public GenerateThread() {
            super(String.valueOf(++createdThreadCount));
            this.start();
        }

        @Override
        public String toString() {
            return this.getName() + " created";
        }
    }
}
