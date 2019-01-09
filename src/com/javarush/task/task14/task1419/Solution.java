package com.javarush.task.task14.task1419;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayStoreException();
        } catch (ArrayStoreException e) {
            exceptions.add(e);
        }

        try {
            throw new ArrayIndexOutOfBoundsException();
        } catch (ArrayIndexOutOfBoundsException e) {
            exceptions.add(e);
        }


        try {
            throw new ClassCastException();
        } catch (ClassCastException e) {
            exceptions.add(e);
        }

        try {
            throw new ConcurrentModificationException();
        } catch (ConcurrentModificationException e) {
            exceptions.add(e);
        }

        try {
            throw new EmptyStackException();
        } catch (EmptyStackException e) {
            exceptions.add(e);
        }

        try {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e)
        {
            exceptions.add(e);
        }

        try {
            throw new IllegalStateException();
        }catch (IllegalStateException e)
        {
            exceptions.add(e);
        }

        try {
            throw new IndexOutOfBoundsException();
        }catch (IndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }

        try {
            throw new NegativeArraySizeException();
        }catch (NegativeArraySizeException e)
        {
            exceptions.add(e);
        }

    }


}
