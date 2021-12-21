package com.javarush.task.task14.task1408;

public class RussianHen extends Hen implements Country {
    int getCountOfEggsPerMonth() {
        return 1917;
    }

    String getDescription() {
        return super.getDescription() + " Моя страна - " + RUSSIA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}

