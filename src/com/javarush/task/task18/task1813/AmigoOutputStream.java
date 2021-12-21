package com.javarush.task.task18.task1813;

import java.io.*;
import java.util.Arrays;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    private FileOutputStream fileOutputStream;
    public AmigoOutputStream(FileOutputStream fileOutputStream) throws FileNotFoundException {
        super(fileName);
    }


    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        fileOutputStream.write(b, off, len);
    }
    public void write(byte[] b) throws IOException {
        fileOutputStream.write(b);
    }
    public void write(int b) throws IOException {
        fileOutputStream.write(b);
    }


    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    public void close() throws IOException {
        fileOutputStream.flush();
        write("JavaRush © All rights reserved.".getBytes());
        fileOutputStream.close();
    }



    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
