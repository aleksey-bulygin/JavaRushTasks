package com.javarush.task.task20.task2017;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) {
        try {
            Object obj = objectStream.readObject();

            if (obj instanceof A)
                return (A) obj;

            if (obj instanceof B)
                return (B) obj;

        } catch (Exception e) {
            //e.printStackTrace();
            return null;
        }
        return null;
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
