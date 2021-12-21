package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            String fileName = reader.readLine();
            if (!fileName.equals("exit")) {
                new ReadThread(fileName).start();
            } else {
                reader.close();
                break;
            }
        }
        System.out.println(resultMap);
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                int[] frequency = new int[1024];
                while (fileInputStream.available() > 0) {
                    frequency[fileInputStream.read()]++;
                }
                fileInputStream.close();
                int max = 0;
                int Char = 0;
                for (int a = 0; a < frequency.length; a++) {
                    if (frequency[a] != 0) {
                        if (frequency[a] > max) {
                            max = frequency[a];
                            Char = a;
                        }
                    }
                }
                resultMap.put(fileName, Char);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
