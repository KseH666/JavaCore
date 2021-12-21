package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<String> strings = new ArrayList<>();
        while (fileReader.ready()) {
            strings.add(fileReader.readLine());
        }
        for (String string : strings) {
            String[] verbs = (string.split(" "));
            for (String verb : verbs) {
                if (Arrays.toString(verb.split("\\D")).length() > 2) {
                    fileWriter.write(verb + " ");
                }
            }
        }
        fileReader.close();
        fileWriter.close();
    }
}
