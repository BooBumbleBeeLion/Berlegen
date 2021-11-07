package ru.uksivt.berlegen;

public class RndBackground {

    public static String random(){
        int w = (int)(Math.random()*(11+1));
        return "fon"+w;
    }
}
