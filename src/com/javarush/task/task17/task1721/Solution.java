package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String firstFileName = reader.readLine();
        String secondFileName = reader.readLine();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(firstFileName)));
        String string;
        while ((string = fileReader.readLine()) != null) {
            allLines.add(string);
        }
        BufferedReader secondFileReader = new BufferedReader(new InputStreamReader(new FileInputStream(secondFileName)));
        while ((string = secondFileReader.readLine()) != null) {
            forRemoveLines.add(string);
        }
        Solution solution = new Solution();
        solution.joinData();
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);

        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }

    }
}
