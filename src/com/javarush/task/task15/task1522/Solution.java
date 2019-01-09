package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {

    static {
        try {
            readKeyFromConsoleAndInitPlanet();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    //add static block here - добавьте статический блок тут

    public static void readKeyFromConsoleAndInitPlanet() throws IOException {
        // implement step #5 here - реализуйте задание №5 тут
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String namePlanet = bufferedReader.readLine();
        boolean itsPlanet = false;

        if (Planet.EARTH.equals(namePlanet))
        {
            itsPlanet = true;
            Earth earth = Earth.getInstance();
            thePlanet = earth;
        }
        if (Planet.MOON.equals(namePlanet))
        {
            itsPlanet = true;
            Moon moon = Moon.getInstance();
            thePlanet = moon;
        }
        if (Planet.SUN.equals(namePlanet))
        {
            itsPlanet = true;
            Sun sun = Sun.getInstance();
            thePlanet = sun;
        }

        if (!itsPlanet)
            thePlanet = null;

    }
}
