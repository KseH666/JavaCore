package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[1]);
        int count = 0;
        while (fileInputStream.available()>0){
            int a = fileInputStream.read();
            if(a>='A'&&a<='Z'||a>='a'&&a<='z'){
                count++;
            }
        }
        fileInputStream.close();
        System.out.println(count);

    }
}
