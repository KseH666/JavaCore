package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));

        while (fileReader.ready()) {
            String value = fileReader.readLine();
            String[] name = value.split("\\w");
            String[] date = value.split("\\W");
            String stringName = "";
            String stringDate = "";
            for (String s : name) {
                stringName = stringName + s;
            }
            for (int i = date.length - 3; i < date.length; i++) {
                stringDate = stringDate + date[i] + " ";
            }
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("d M y");
            Date dat = format.parse(stringDate.substring(0, stringDate.length() - 1));
            PEOPLE.add(new Person(stringName.trim(), dat));
        }
        fileReader.close();
    }
}
