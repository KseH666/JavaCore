package com.javarush.task.task14.task1408;

public class BelarusianHen extends Hen implements Country {
    int getCountOfEggsPerMonth() {
        return 143;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + BELARUS + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}