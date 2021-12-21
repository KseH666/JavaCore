package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        BufferedInputStream buffIn = new BufferedInputStream(new FileInputStream(fileName));
        BufferedOutputStream buffOut = new BufferedOutputStream(new FileOutputStream(fileOutputName));

        switch (args[0]) {

            case "-e": {
                while (buffIn.available() > 0) {
                    buffOut.write(buffIn.read() + 1);
                }

            }


            case "-d": {
                while (buffIn.available() > 0) {
                    buffOut.write(buffIn.read() - 1);
                }

            }
            buffIn.close();
            buffOut.close();

        }


    }
}



