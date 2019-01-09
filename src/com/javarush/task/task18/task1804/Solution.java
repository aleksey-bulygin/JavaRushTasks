package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName);
        ArrayList<Integer> byteList = new ArrayList<>();

        while (fileInputStream.available() > 0)
            byteList.add(fileInputStream.read());

        fileInputStream.close();

        Collections.sort(byteList);

        HashMap<Integer, Integer> mapByteCount = getReturnMap(byteList);

        int maxCount = 10000000;

        for (Map.Entry<Integer, Integer> map : mapByteCount.entrySet()) {
            if (maxCount > map.getValue())
                maxCount = map.getValue();
        }

        for (Map.Entry<Integer, Integer> map : mapByteCount.entrySet()) {
            if (maxCount == map.getValue())
                System.out.print(map.getKey() + " ");
        }

    }


    public static HashMap<Integer, Integer> getReturnMap(ArrayList<Integer> list) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int number : list) {
            int countTurn = 0;

            for (int i = 0; i < list.size(); i++) {
                if (number == list.get(i))
                    countTurn++;
            }
            hashMap.put(number, countTurn);
        }

        return hashMap;
    }
}
