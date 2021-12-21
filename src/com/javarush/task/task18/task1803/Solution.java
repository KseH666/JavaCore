package com.javarush.task.task18.task1803;

/* 
Самые частые байты
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        List<Integer> list = new ArrayList<>();
        while (fileInputStream.available() > 0) {
            list.add(fileInputStream.read());
        }
        fileInputStream.close();
        Collections.sort(list);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 1;
        for (int a = 0; a < list.size() - 1; a++) {
            if (list.get(a).equals(list.get(a + 1))) {
                count++;
                if (a == list.size() - 2) {
                    map.put(list.get(a), count);
                }
            } else {
                map.put(list.get(a), count);
                count = 1;
            }
        }
        List<Integer> mapKeys = new ArrayList<>(map.keySet());
        List<Integer> mapValues = new ArrayList<>(map.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();

        for (int val : mapValues) {
            Iterator<Integer> keyIt = mapKeys.iterator();
            while (keyIt.hasNext()) {
                Integer key = keyIt.next();
                int comp1 = map.get(key);

                if ((comp1) == (val)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        List<Integer> list1 = new ArrayList<>(sortedMap.values());
        List<Integer> list2 = new ArrayList<>(sortedMap.keySet());
        String a = list2.get(list2.size() - 1) + " ";
        for (int z = list1.size() - 1; z > 0; z--) {
            if (list1.get(z).equals(list1.get(z - 1))) {
                a = a.concat(list2.get(z - 1) + " ");
            } else break;
        }
        System.out.println(a.substring(0, a.length() - 1));
    }
}
