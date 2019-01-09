package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    public static volatile int index;

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут


        SimpleDateFormat bdInputFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);
        SimpleDateFormat bdOutputFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);


        switch (args[0]) {
            case "-c" :

                synchronized (allPeople) {
                    index = 1;

                    while (index + 2 < args.length) {
                        if ("м".equals(args[index + 1])) //check sex
                            allPeople.add(Person.createMale(args[index], bdInputFormat.parse(args[index + 2])));
                        else
                            allPeople.add(Person.createFemale(args[index], bdInputFormat.parse(args[index + 2])));

                        System.out.println(allPeople.size() - 1);
                        index += 3;
                    }

                    break;
                }

            case "-u" :
                index = 1;
                synchronized (allPeople) {

                    while (index + 3 < args.length) {
                        int id = Integer.parseInt(args[index]);

                        allPeople.get(id).setName(args[index + 1]);

                        if ("м".equals(args[index + 2]))
                            allPeople.get(id).setSex(Sex.MALE);
                        else
                            allPeople.get(id).setSex(Sex.FEMALE);

                        allPeople.get(id).setBirthDate(bdInputFormat.parse(args[index + 3]));

                        index += 4;
                    }

                    break;
                }

            case "-d" :

                synchronized (allPeople) {
                    for (index = 1; index < args.length; index++ ) {
                        int id = Integer.parseInt(args[index]);

                        allPeople.get(id).setName(null);
                        allPeople.get(id).setSex(null);
                        allPeople.get(id).setBirthDate(null);
                    }

                    break;
                }

            case "-i" :

                synchronized (allPeople) {
                    for (index = 1; index < args.length; index++) {
                        int id = Integer.parseInt(args[index]);
                        char tmpSex = (allPeople.get(id).getSex() == Sex.MALE) ? 'м' : 'ж';

                        System.out.println(allPeople.get(id).getName() + " " + tmpSex + " " + bdOutputFormat.format(allPeople.get(id).getBirthDate()));
                    }

                    break;
                }


        }
    }

    private synchronized static void initializeCrUD(String[] args) throws ParseException {


    }
}
