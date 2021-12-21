package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader readerIn = new BufferedReader(new InputStreamReader(System.in));
        Map<String, byte[]> map = new HashMap<>();
        String fileIn = "";
        for (; ; ) {
            String fileName = readerIn.readLine();
            if (!fileName.equals("end")) {
                BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
                while (fileInputStream.available() > 0) {
                    byte[] bytes = new byte[fileInputStream.available()];
                    for (int a = 0; a < bytes.length; a++) {
                        bytes[a] = (byte) fileInputStream.read();
                    }
                    String fp = fileName.substring(fileName.lastIndexOf(".") + 1);
                    map.put(fp, bytes);
                    fileIn = fileName.substring(0, fileName.lastIndexOf("."));
                }
                fileInputStream.close();
            } else {
                break;
            }
        }
        readerIn.close();
        BufferedOutputStream fileOutputStream = new BufferedOutputStream(new FileOutputStream(fileIn, true));
        for (int a = 1; a <= map.size(); a++) {
            fileOutputStream.write(map.get("part" + a));
            if (a == map.size()) {
                fileOutputStream.close();
            }
        }
    }
}
