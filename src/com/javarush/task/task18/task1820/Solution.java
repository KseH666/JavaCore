package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder get = new StringBuilder();
        double tr;
        int ha;
        List<Character> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            list.add((char) fileInputStream.read());
        }
        fileInputStream.close();
        for (int a = 0; a < list.size(); a++) {
            if (!list.get(a).equals(' ')) {
                if (a == list.size() - 1) {
                    tr = Double.parseDouble(get.toString());
                    ha = (int) Math.round(tr);
                    String haha = ha + " ";
                    char[] b = haha.toCharArray();
                    for (int z = 0; z < b.length - 1; z++) {
                        fileOutputStream.write((byte) b[z]);
                    }
                } else {
                    get.append(list.get(a));
                }
            } else {
                tr = Double.parseDouble(get.toString());
                ha = (int) Math.round(tr);
                String haha = ha + " ";
                char[] b = haha.toCharArray();
                for (char c : b) {
                    fileOutputStream.write((byte) c);
                }
                get = new StringBuilder();
            }
        }
        fileOutputStream.close();
    }
}
