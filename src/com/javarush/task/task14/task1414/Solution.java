package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7

        /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Movie movie = null;

        while (true)
        {
            String key = bufferedReader.readLine();

            if ( ("cartoon".equals(key)) || ("soapOpera".equals(key)) || ("thriller".equals(key)) )
            {
                movie = MovieFactory.getMovie(key);
                System.out.println(movie.getClass().getSimpleName());
            }
            else
            {
                movie = MovieFactory.getMovie(key);
                break;
            }

        }

    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            }

            //напишите тут ваш код, пункты 5,6
            if ("cartoon".equals(key)) {
                movie = new Cartoon();
            }

            if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3

    public static class Cartoon extends Movie {

    }

    public static class Thriller extends Movie {

    }
}
