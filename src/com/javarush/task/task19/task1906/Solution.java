package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(file1);
        FileWriter fw = new FileWriter(file2);
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (fr.ready()) {
            list.add(fr.read());
        }
        for (int a = 1; a < list.size(); a++) {
            if (a % 2 == 0) {
                fw.write(list.get(a));
            }
        }
        fr.close();
        fw.close();
    }
}
