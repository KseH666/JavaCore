package com.javarush.task.task15.task1522;

/* 
Закрепляем паттерн Singleton
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        switch (name) {
            case Planet.SUN -> thePlanet = Sun.getInstance();
            case Planet.MOON -> thePlanet = Moon.getInstance();
            case Planet.EARTH -> thePlanet = Earth.getInstance();
            default -> thePlanet = null;
        }
    }
}
