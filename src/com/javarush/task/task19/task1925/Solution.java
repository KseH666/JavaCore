package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);
        String[] slot;
        ArrayList<Character> bytes = new ArrayList<>();
        int z = 0;
        while (fileReader.ready()) {
            int a = fileReader.read();
            if (a != 13 && a != 10) {
                bytes.add((char) a);
            } else if (a == 13) {
                bytes.add((char) 32);
            }
        }
        String line = "";
        for (Character aByte : bytes) {
            line = line + aByte;
        }
        slot = line.split(" ");
        String ok = "";
        for (String s : slot) {
            if (s.length() > 6) {
                ok = ok + s + ",";
            }
        }
        fileWriter.write(ok.substring(0,ok.length()-1));
        fileReader.close();
        fileWriter.close();
    }
}
