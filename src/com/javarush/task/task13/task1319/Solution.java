package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String filename = bufferedReader.readLine();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename));

        while (true)
        {
            String string = bufferedReader.readLine();
            bufferedWriter.write(string + "\n");

            if (string.equals("exit"))
                break;
        }
        bufferedReader.close();
        bufferedWriter.close();





    }
}
