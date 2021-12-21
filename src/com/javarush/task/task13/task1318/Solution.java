package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = null;
        BufferedInputStream bis = null;
        List<Character> list = new ArrayList<>();
        try {
            is = new FileInputStream(reader.readLine());
            bis = new BufferedInputStream(is);
            while (bis.available() > 0) {
                char a = (char) bis.read();
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            is.close();
            bis.close();
            reader.close();
        }
        for (Character character : list) {
            System.out.print(character);
        }
    }
}