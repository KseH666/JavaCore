package com.javarush.task.task20.task2026;

import java.util.Arrays;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int Ny = a.length;
        int g = 0;
        for (int y = 0; y < Ny; y++) {
            int Nx = a[y].length;
            for (int x = 0; x < Nx; x++) {
                try {
                    if (a[y][x] == 1 && a[y][x + 1] == 0 && a[y + 1][x] == 0) {
                        g++;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    g++;
                }
            }
        }

        return g;
    }
}
