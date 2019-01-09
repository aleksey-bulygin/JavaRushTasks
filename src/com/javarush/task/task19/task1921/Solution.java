package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

    public static void main(String[] args) throws IOException, ParseException {

        if (args.length != 0) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

            while (bufferedReader.ready()) {
                StringBuffer name = new StringBuffer("");
                int day;
                int month;
                int year;

                String[] tmpLines = bufferedReader.readLine().split(" ");

                for(String string : tmpLines) {
                    if (!isIntNumber(string))
                        name.append(string + " ");
                }

                year = Integer.parseInt(tmpLines[tmpLines.length - 1]);
                month = Integer.parseInt(tmpLines[tmpLines.length - 2]);
                day = Integer.parseInt(tmpLines[tmpLines.length - 3]);

                PEOPLE.add(new Person(name.toString().trim(), simpleDateFormat.parse(day + " " + month + " " + year)));
            }
            bufferedReader.close();
        }

    }

    public static boolean isIntNumber(String string) {
        boolean isInt = true;

        try {
            int a = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            isInt = false;
        }

        return isInt;
    }
}
