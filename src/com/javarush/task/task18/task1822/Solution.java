package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static String info;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        int id = Integer.parseInt(args[0]);

        bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()) {
            String infoLine = bufferedReader.readLine();
            String[] paramInfoLine = infoLine.split(" ");

            if (Integer.parseInt(paramInfoLine[0]) == id)
                info = infoLine;
        }

        bufferedReader.close();

        System.out.println(info);

    }

}
