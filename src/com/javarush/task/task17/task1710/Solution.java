package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        initializeCRUD(args);
    }

    private static void initializeCRUD(String[] args) throws ParseException {
        String name;
        Sex sex;
        int id;
        Date bd;

        SimpleDateFormat bdFormat = new SimpleDateFormat("dd/MM/y", Locale.ENGLISH);

        switch (args[0]) {
            case "-c" :
                name = args[1];
                sex = ("м".equals(args[2])) ? Sex.MALE : Sex.FEMALE;
                bd = bdFormat.parse(args[3]);

                if (sex == Sex.MALE)
                    allPeople.add(Person.createMale(name, bd));
                else
                    allPeople.add(Person.createFemale(name, bd));

                System.out.println(allPeople.size() - 1);

                break;

            case "-u" :
                id = Integer.parseInt(args[1]);
                name = args[2];
                sex = ("м".equals(args[3])) ? Sex.MALE : Sex.FEMALE;
                bd = bdFormat.parse(args[4]);

                allPeople.get(id).setName(name);
                allPeople.get(id).setSex(sex);
                allPeople.get(id).setBirthDate(bd);

                break;

            case "-d" :
                id = Integer.parseInt(args[1]);
                allPeople.get(id).setName(null);
                allPeople.get(id).setBirthDate(null);
                allPeople.get(id).setSex(null);

                break;

            case "-i" :
                id = Integer.parseInt(args[1]);
                char tmpsex = (allPeople.get(id).getSex() == Sex.MALE) ? 'м' : 'ж';

                System.out.println(allPeople.get(id).getName() + " " + tmpsex + " " +
                        (new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH)).format(allPeople.get(id).getBirthDate()));
                break;
        }

    }
}
