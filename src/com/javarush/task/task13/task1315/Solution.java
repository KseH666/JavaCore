package com.javarush.task.task13.task1315;

/* 
Том, Джерри и Спайк
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface Movable {
        void move();
    }

    public interface Edible {
        void beEaten();
    }

    public interface Eat {
        void eat();
    }

    static class Cat implements Movable, Edible, Eat {
        public void move() {
        }

        public void beEaten() {
        }

        public void eat() {
        }
    }

    static class Dog implements Movable, Eat {
        public void move() {
        }

        public void eat() {
        }
    }

    static class Mouse implements Movable, Edible {
        public void move() {
        }

        public void beEaten() {
        }

    }

}