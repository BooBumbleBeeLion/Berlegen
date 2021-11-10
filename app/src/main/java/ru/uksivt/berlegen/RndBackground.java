package ru.uksivt.berlegen;

public class RndBackground {

    public static String random(){
        int w = (int)(Math.random()*(12+1));
        return "fon"+w;
    }
}
