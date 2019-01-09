package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner scanner){
            fileScanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
        //    if (fileScanner.hasNext())
                String[] personData = fileScanner.nextLine().split(" ");

            String lastName = personData[0];
            String firstName = personData[1];
            String middleName = personData[2];
            String day = personData[3];
            String month = personData[4];
            String year = personData[5];
            String br = day + " " + month + " " + year;

            SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
          //  SimpleDateFormat sdf  = new SimpleDateFormat("ddMMyyyy");
            Date dob = format.parse(day + month + year);

            return new Person(firstName, middleName, lastName, dob);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
