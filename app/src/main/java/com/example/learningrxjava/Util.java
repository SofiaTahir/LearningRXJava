package com.example.learningrxjava;

public class Util {

    public static boolean checkStringEmpty(String input) {
        if (input != null && !input.isEmpty())
            return false;
        else return true;
    }

    public static boolean checkIDValid(int id){
        if (id >= 1 && id <= 10)
            return true;
        else return false;
    }
}
