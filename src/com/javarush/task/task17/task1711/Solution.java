package com.javarush.task.task17.task1711;

import java.util.*;
import java.text.SimpleDateFormat;

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));
        allPeople.add(Person.createMale("Петров Петр", new Date()));
    }

    public static void main(String[] args) throws Exception {
        int id;
        String name;
        String sex;
        Date bd;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        switch (args[0]) {
            case "-c": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        name = args[i++];
                        sex = args[i++];
                        bd = dateFormat.parse(args[i++]);
                        if (sex.equals("ж")) {
                            allPeople.add(Person.createFemale(name, bd));
                        } else if (sex.equals("м")) {
                            allPeople.add(Person.createMale(name, bd));
                        }
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            }
            case "-u": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        id = Integer.parseInt(args[i++]);
                        name = args[i++];
                        sex = args[i++];
                        bd = dateFormat.parse(args[i++]);

                        allPeople.get(id).setName(name);
                        if (sex.equals("м")) {
                            allPeople.get(id).setSex(Sex.MALE);
                        } else {
                            allPeople.get(id).setSex(Sex.FEMALE);
                        }
                        allPeople.get(id).setBirthDate(bd);
                    }
                    break;
                }
            }
            case "-d": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {
                        id = Integer.parseInt(args[i++]);
                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }
                    break;
                }
            }
            case "-i": {
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; ) {

                        id = Integer.parseInt(args[i++]);
                        String s = allPeople.get(id).getSex() == Sex.MALE ? "м" : "ж";
                        System.out.println(allPeople.get(id).getName() + " " + s + " " + format.format(allPeople.get(id).getBirthDate()));
                    }
                    break;
                }
            }
        }
    }
}