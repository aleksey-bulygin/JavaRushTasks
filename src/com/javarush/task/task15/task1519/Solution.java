package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true)
        {
            String value = bufferedReader.readLine();

            if("exit".equals(value))
                break;
            try
            {
                Integer integerNumber = Integer.parseInt(value);

                if (integerNumber <= 0 || integerNumber >= 128) {
                    print(integerNumber);
                }
                else {
                    print(Short.parseShort(value));
                }
            } catch (NumberFormatException e){

                try {
                    Double doubleNumber = Double.parseDouble(value);
                    print(doubleNumber);
                } catch (NumberFormatException k)
                {
                    print(value);
                }
            }
        }
    }



    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
