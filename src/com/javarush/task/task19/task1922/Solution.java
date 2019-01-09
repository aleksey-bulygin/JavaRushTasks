package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        ArrayList<String[]> linesFromFile = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            linesFromFile.add(bufferedReader.readLine().split(" "));
        }
        bufferedReader.close();

        for (int i = 0; i < linesFromFile.size(); i++) {
            int isWordEqual = 0;

            for (String string : linesFromFile.get(i)) {
                for (String stringFromWords : words)
                    if (string.equals(stringFromWords))
                        isWordEqual++;
            }
            if (isWordEqual == 2)
                for (String string : linesFromFile.get(i))
                    System.out.print(string + " ");
                System.out.println();
        }

    }
}
