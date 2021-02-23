package edu.reboot.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class SubTask_2 {
    private static HashMap<Character, Integer> map = new HashMap<>();

//    private static void initDictionary(char[] dict) {
//        for(char c : dict)
//            map.put(c, 0);
//    }

    public static void calculateChars() {

    }

    public static void main (String[] args) {

        String dict = "abcdefghijklnmopqrstuvwxyz";
        for(char c : dict.toCharArray())
            map.put(c, 0);

        try {
            FileInputStream inputStream = new FileInputStream("./src/main/resources/input.txt");

            while (inputStream.available() > 0) {
                int ch = inputStream.read();

                //map.

                System.out.println((char) ch);
            }

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
