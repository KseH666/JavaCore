package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bufferedReader.readLine();
        String file2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader fileReader = new BufferedReader(new FileReader(file1));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file2));
        while (fileReader.ready()) {
            int fr = fileReader.read();
            if (fr == 46) {
                fileWriter.write(33);
            } else {
                fileWriter.write(fr);
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
