package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Парсер реквестов
*/

public class Solution {

    public static void main(String[] args) {
        //add your code here

        String urlLink = null;
        ArrayList<String> paramLinksList;

        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            urlLink = bufferedReader.readLine();
            bufferedReader.close();

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        if (checkUrlLink(urlLink)) {

            paramLinksList = getListFromLink(urlLink.replaceAll("\\s", ""));

            for (String string : paramLinksList)
            {
                if (string.indexOf("=") == -1)
                    System.out.print(string + " ");
                else {
                    String[] bufferStringLink = string.split("=");
                    System.out.print(bufferStringLink[0] + " ");
                }
            }

            System.out.println();

            for (String string : paramLinksList)
                goToAlertMethod(string);


        }
    }


    public static void goToAlertMethod(String stringParamLink)
    {
        if (stringParamLink.indexOf("=") != -1)
        {
            String[] tmpString = stringParamLink.split("=");

            if ("obj".equals(tmpString[0]))
            {
                if (doubleCheck(tmpString[1]))
                    alert(Double.parseDouble(tmpString[1]));
                else
                    alert(tmpString[1]);
            }
        }
    }

    public static boolean doubleCheck(String checkString)
    {
        try {
            Double d = Double.parseDouble(checkString);
            return true;
        }catch (NumberFormatException e)
        {
            return false;
        }
    }


    public static boolean checkUrlLink(String urlLink)
    {
        if (urlLink.indexOf("&") > urlLink.indexOf("?"))
            return true;
        else
            return false;
    }

    public static ArrayList<String> getListFromLink(String urlLink)
    {
        ArrayList<String> list = new ArrayList<>();

        urlLink = new StringBuffer(urlLink).substring(urlLink.indexOf("?") + 1);

        String[] parametersLink = urlLink.split("&");

        for (String string : parametersLink)
            list.add(string);

        return list;
    }



    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
