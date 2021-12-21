package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();
        String stringBuilder = "";
        BufferedReader readerFile1 = new BufferedReader(new FileReader(file1));
        BufferedWriter writerFile2 = new BufferedWriter(new FileWriter(file2));
        while ((stringBuilder = readerFile1.readLine()) != null) {
            writerFile2.write(stringBuilder.replaceAll("\\p{Punct}", ""));
        }
        FileWriter fileWriter = new FileWriter(file1);
        fileWriter.close();
        readerFile1.close();
        writerFile2.close();
    }
}
