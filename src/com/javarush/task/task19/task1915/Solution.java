package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader readName = new BufferedReader(new InputStreamReader(System.in));
        String fileName = readName.readLine();
        readName.close();
        PrintStream printStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);

        System.setOut(printStream);
        outputStream.writeTo(fileOutputStream);
        fileOutputStream.close();
        System.out.println(result);
        outputStream.close();
        printStream.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

