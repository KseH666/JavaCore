package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<>();

    public Solution() {
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }

    static {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(Statics.FILE_NAME)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                if (!reader.ready()) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                lines.add(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
