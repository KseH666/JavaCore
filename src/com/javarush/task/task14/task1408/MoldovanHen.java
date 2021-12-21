package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
     int getCountOfEggsPerMonth() {
        return 1991;
    }

     String getDescription() {
        return super.getDescription() + " Моя страна - " + MOLDOVA + ". Я несу " + getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}