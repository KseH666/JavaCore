package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        BufferedReader fr = new BufferedReader(new FileReader(file1));
        BufferedWriter fw = new BufferedWriter(new FileWriter(file2));
        String all = "";
        while (fr.ready()) {
            all = all + (char) fr.read();
        }
        String[] words = all.split("\\s");
        String numbs = "";

        for (int z = 0; z < words.length; z++) {
            try {
                Long.parseLong(words[z]);
                numbs = numbs + words[z]+" ";
                fw.write(words[z]);

            } catch (Exception ignored){
            }
        }
        char [] chars = numbs.toCharArray();
        for (int i = 0; i < chars.length-1; i++){
            fw.write(chars[i]);
        }
        fr.close();
        fw.close();
    }
}