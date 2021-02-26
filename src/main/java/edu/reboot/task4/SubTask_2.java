package edu.reboot.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class SubTask_2 {

    public static void main (String[] args) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Инициализация словаря
        String dict = "abcdefghijklnmopqrstuvwxyz";
        for(char c : dict.toCharArray())
            map.put(c, 0);

        try {
            FileInputStream inputStream = new FileInputStream("./src/main/resources/input.txt");

            // Читаем символ, берем текущее значение и перезаписываем с увеличением
            while (inputStream.available() > 0) {
                char ch = (char)inputStream.read();
                int value = map.get(ch);
                map.put(ch, ++value);
            }
            System.out.println(map);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
