package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker latteMaker = new LatteMaker();
        latteMaker.makeDrink();
        DrinkMaker teaMaker = new TeaMaker();
        teaMaker.makeDrink();
    }
}
