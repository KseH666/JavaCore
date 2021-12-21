package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScanner ps = new PersonScannerAdapter(new Scanner(new File("C:/Users/KseH/Desktop/text0.txt")));
        Person person = ps.read();
        System.out.println(person);
        ps.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        public Person read() throws IOException, ParseException {
            SimpleDateFormat dateFormat = new SimpleDateFormat("d M y", Locale.ENGLISH);
            String line =  fileScanner.nextLine(); //прочел запись в файле
            String[]arr =  line.split(" ",4);//Разбил на 4 строки, последняя с датой
            return new Person(arr[1],arr[2],arr[0],dateFormat.parse(arr[3]));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
