package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNameList = new ArrayList<>();
        ArrayList<Integer> partNList = new ArrayList<>();

        while (true) {
            String filename = bufferedReader.readLine();
            if ("end".equals(filename))
                break;
            else {
                String[] tmpString = filename.split("part");
                fileNameList.add(filename);
                partNList.add(Integer.parseInt(tmpString[1]));
            }
        }

        Collections.sort(partNList);
        String[] str = fileNameList.get(0).split(".part");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(str[0]));


        for (int index : partNList) {
            for (String string : fileNameList) {
                String[] tmpString = string.split("part");

                if (index == Integer.parseInt(tmpString[1]))
                {
                    bufferedReader = new BufferedReader(new FileReader(string));
                    while (bufferedReader.ready())
                        bufferedWriter.write(bufferedReader.readLine());

                    bufferedReader.close();

                }
            }
        }

        bufferedWriter.close();

    }
}
