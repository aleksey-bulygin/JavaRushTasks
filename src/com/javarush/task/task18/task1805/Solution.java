package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Сортировка байт
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


        byteList.clear();

        for (Map.Entry<Integer, Integer> map : mapByteCount.entrySet()) {
            byteList.add(map.getKey());
        }

        Collections.sort(byteList);

        for (int number : byteList)
            System.out.print(number + " ");



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
