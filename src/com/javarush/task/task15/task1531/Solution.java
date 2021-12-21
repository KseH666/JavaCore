package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();
        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger B = BigInteger.valueOf(n);
        BigInteger a = B.subtract(BigInteger.valueOf(1));
        if (n > 0 && n <= 150) {
            for (int i = Integer.parseInt(a.toString()); i >= 1; i--)
                B = B.multiply(BigInteger.valueOf(i));
            return B + "";
        }
        if (n == 0) {
            return "1";
        } else return "0";
    }
}
