package com.javarush.task.task12.task1217;

/* 
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

//add interfaces here - добавь интерфейсы тут
    public interface CanFly
    {
        default void fly()
        {

        }
    }

    public interface CanRun
    {
        default void run()
        {

        }
    }

    public interface CanSwim
    {
        default void swim()
        {

        }
    }

}
