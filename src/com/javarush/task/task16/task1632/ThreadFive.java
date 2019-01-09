package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class ThreadFive extends ThreadsSolution {
    private static BufferedReader bufferedReader;
    private static ArrayList<Integer> integerArrayList = new ArrayList<>();

    @Override
    public void run() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            try {
                String stringNumber = bufferedReader.readLine();
                if ("N".equals(stringNumber))
                    break;
                else
                    integerArrayList.add(Integer.parseInt(stringNumber));
            } catch (IOException e) {
            }
        }
        System.out.println(getSumReadNumbers(integerArrayList));
    }

    private static int getSumReadNumbers(ArrayList<Integer> arrayList) {
        int n = 0;

        for (int number : arrayList)
            n += number;

        return n;
    }
}
