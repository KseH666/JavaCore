package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        Properties properties = new Properties();
        properties.putAll(runtimeStorage);
        properties.store(outputStream,"");
    }

    public static void load(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        properties.load(inputStream);
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            runtimeStorage.put(entry.getKey().toString(), entry.getValue().toString());
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            FileInputStream fis = new FileInputStream(reader.readLine());
            FileOutputStream fos = new FileOutputStream(reader.readLine());
            load(fis);
            save(fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);

    }
}
