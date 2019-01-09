package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {
        //add your code here - добавьте код тут
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static CanFly result;

    public static void reset() throws IOException {
        //add your code here - добавьте код тут

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String vehicle = bufferedReader.readLine();

        if ("helicopter".equals(vehicle))
        {
            Helicopter helicopter = new Helicopter();
            result = helicopter;
        }

        if ("plane".equals(vehicle))
        {
            Plane plane = new Plane(Integer.parseInt(bufferedReader.readLine()));
            result = plane;
        }

        bufferedReader.close();
    }
}
