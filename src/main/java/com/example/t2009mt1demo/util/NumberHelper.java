package com.example.t2009mt1demo.util;
import java.util.Random;

public class NumberHelper {
    public static int numberRandom(int min, int max){
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
}