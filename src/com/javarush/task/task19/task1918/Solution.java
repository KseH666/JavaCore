//package com.javarush.task.task19.task1918;
//
///*
//Знакомство с тегами
//*/
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.parser.Parser;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
//        String name = fileName.readLine();
//        fileName.close();
//        BufferedReader file = new BufferedReader(new FileReader(name));
//        StringBuilder fileTags = new StringBuilder();
//        while (file.ready()) {
//            fileTags.append(file.readLine());
//        }
//        file.close();
//        Document a = Jsoup.parse(fileTags.toString(), "", Parser.xmlParser());
//        System.out.println(a.select(args[0]));
//    }
//}
