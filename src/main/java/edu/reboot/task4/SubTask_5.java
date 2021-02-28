package edu.reboot.task4;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;

public class SubTask_5 {

    private static HashMap<String, Integer> scoresMap = new HashMap<>();
    private static String winnerName;
    private static int maxScores = 0;

    private static void checkMaxScores(String name, int score) {
        if(score > maxScores) {
            maxScores = score;
            winnerName = name;
        }
    }

    public static void main (String[] args) throws IOException {
        try {
            Scanner in = new Scanner(Paths.get("./src/main/resources/input_5.txt"));
            String str = in.nextLine().replaceAll("\"|,", "");
            in = new Scanner(str);

            while(in.hasNext()) {
                String name = in.next();
                int score = in.nextInt();

                if(scoresMap.putIfAbsent(name, score) != null) {
                    scoresMap.compute(name, (a,b) -> b + score);
                    checkMaxScores(name, scoresMap.get(name));
                }
            }

            System.out.println("Winner " + winnerName + " with scores " + maxScores);

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
