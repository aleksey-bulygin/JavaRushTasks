package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Максимальный байт
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

        System.out.println(byteList.get(byteList.size() - 1));
    }
}
