package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");

    }

    public static void main(String[] args) throws IOException {
        ArrayList<String[]> dataFromFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));
        while (bufferedReader.ready())
            dataFromFile.add(bufferedReader.readLine().split(" "));
        bufferedReader.close();

        for (int i = 0; i < dataFromFile.size(); i++) {

            for (int j = 0; j < dataFromFile.get(i).length; j++) {
                if ( isCheckString(dataFromFile.get(i)[j])) {
                    dataFromFile.get(i)[j] = map.get(Integer.parseInt(dataFromFile.get(i)[j]));
                }
            }
        }

        for (int i = 0; i < dataFromFile.size(); i++) {
            for (String string : dataFromFile.get(i))
                System.out.print(string + " ");
            System.out.println();
        }

    }

    public static boolean isCheckString(String string) {
        boolean isCheck = true;

        try {
            int a = Integer.parseInt(string);
            if ( !(a >= 0 && a <= 12) )
                throw new NumberFormatException();
        } catch (NumberFormatException e) {
            isCheck = false;
        }

        return isCheck;
    }
}
