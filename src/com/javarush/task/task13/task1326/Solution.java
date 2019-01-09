package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        List<Integer> integerList = new ArrayList<Integer>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();
        bufferedReader.close();

        InputStream inputStream = new FileInputStream(filename);
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        while (bufferedReader.ready())
        {
            int number = Integer.parseInt(bufferedReader.readLine());

            if (number % 2 == 0)
                integerList.add(number);
        }
        inputStream.close();
        bufferedReader.close();

        Collections.sort(integerList);

        for (int number : integerList)
        {
                System.out.println(number);
        }

    }
}
