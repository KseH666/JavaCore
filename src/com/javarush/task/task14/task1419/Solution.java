package com.javarush.task.task14.task1419;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/


public class Solution {
    public static List<Exception> exceptions = new ArrayList<>();

    public static void main(String[] args) {
        initExceptions();


        for (Exception exception : exceptions) {
            System.out.println(exception);
        }

    }


    private static void initExceptions() {

        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            File file = new File("path");
            FileInputStream fis = new FileInputStream(file);
            String s = "inside";
        } catch (FileNotFoundException e) {
            exceptions.add(e);
        }
        try {
            Integer.parseInt(null);
        } catch (NumberFormatException e) {
            exceptions.add(e);
        }
        try {
            Double.parseDouble(null);
        } catch (NullPointerException e) {
            exceptions.add(e);
        }
        try {
            int b;
            int[] a = new int[5];
            b = a[6];
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }
        try {
            int z = 0;
            z = getAreaValue(-1, 100);

        } catch (IllegalArgumentException e) {
            exceptions.add(e);
        }
        try {
            Object x[] = new String[3];
            x[0] = new Integer(0);

        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }
        try {
            Object obj = new java.util.Date();
            Integer int1 = (Integer) obj;

        } catch (ClassCastException e) {
            exceptions.add(e);
        }
        try {
            int[] data = new int[-5];
            for (int i = 0; i < data.length; i++) {
                data[i] = (int) (Math.random() * 100);
            }

        } catch (NegativeArraySizeException e) {
            exceptions.add(e);
        }
        try {
            List<String> stringList = new ArrayList<>();
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");
            stringList.add("5");


            for (int i = 0; i < stringList.size(); i++) {
                if (Character.isDigit(stringList.get(i).charAt(i))) {
                    stringList.get(i);
                } else {
                    stringList.get(i);
                }
            }

        } catch (StringIndexOutOfBoundsException e) {
            exceptions.add(e);
        }


    }

    public static int getAreaValue(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException("value of 'x' or 'y' is negative: x=" + x + ", y=" + y);
        return x * y;
    }
}