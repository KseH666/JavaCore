package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(fileName);
        List<Integer>byteList = new ArrayList<>();
        while (fileInputStream.available()>0){
            int data = fileInputStream.read();
            byteList.add(data);
        }
        reader.close();
        fileInputStream.close();
        Collections.sort(byteList);
        System.out.println(byteList.get(byteList.size()-1));

    }
}
