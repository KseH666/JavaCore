package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (int i = 0; ; i++) {
                String string = reader.readLine();
                if (string.equals("exit")) {
                    bw.write(string+"\n");
                    break;
                }
                bw.write(string+"\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
