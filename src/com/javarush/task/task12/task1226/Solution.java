package com.javarush.task.task12.task1226;

/* 
Лазать, летать и бегать
*/

public class Solution {
    public interface CanFly {
        void fly();
    }

    public interface CanClimb {
        void climb();
    }

    public interface CanRun {
        void run();
    }

    public static void main(String[] args) {

    }

    public static class Cat implements CanClimb, CanRun {
        public void climb() {
        }

        public void run() {
        }
    }

    public static class Dog implements CanRun {

        public void run() {
        }

    }

    public static class Tiger extends Cat {
        public void climb() {
        }

        public void run() {
        }
    }

    public static class Duck implements CanFly, CanRun {
        public void fly() {
        }

        public void run() {
        }
    }
}
