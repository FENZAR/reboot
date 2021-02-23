package edu.reboot.task1;

import java.util.*;
import static java.lang.System.out;

public class task1 {

    private static final double C100_FUEL_CONSUMPTION = 12.5;
    private static final double C200_FUEL_CONSUMPTION = 12.0;
    private static final double C300_FUEL_CONSUMPTION = 11.5;
    private static final double C400_FUEL_CONSUMPTION = 20.0;

    private static final double C100_FUEL_COST = 46.10;
    private static final double C200_FUEL_COST = 48.90;
    private static final double C300_FUEL_COST = 47.50;
    private static final double C400_FUEL_COST = 48.90;

    private static String[] GSM = {
            "C100_1-100",
            "C200_1-120-1200",
            "C300_1-120-30",
            "C400_1-80-20",
            "C100_2-50",
            "C200_2-40-1000",
            "C300_2-200-45",
            "C400_2-10-20",
            "C100_3-10",
            "C200_3-170-1100",
            "C300_3-150-29",
            "C400_3-100-28",
            "C100_1-300",
            "C200_1-100-750",
            "C300_1-32-15"
    };

    private static int [][] transportInfoMassiv;

    private static int parseElement(String element) {
        try {
            return Integer.parseInt((element));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void infoByType(int type) {
        int[][] array = new int[transportInfoMassiv.length][4];
        int sortColumn = 2; // пробег
        int[] tmp = new int[4];

        for (int i = 0, j = 0; i < transportInfoMassiv.length; i++) {
                if (transportInfoMassiv[i][0] == type) {
                        array[j++] = transportInfoMassiv[i];
                }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i][sortColumn] < array[j][sortColumn]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }

        out.println("C" + type + ":");
        for (int[] ints : array) {
            if (ints[0] > 0) {
                System.out.println(Arrays.toString(ints));
            }
        }

    }

    public static void main(String[] args) {
        int C100_mileage = 0, C200_mileage = 0, C300_mileage = 0, C400_mileage = 0;
        double total_cost = 0;

        transportInfoMassiv = new int[GSM.length][4];

        for (int i = 0; i < GSM.length; i++) {

            String[] tail = (GSM[i].split("_")[1]).split("-");

            int type = parseElement((GSM[i].split("_")[0]).substring(1,4));
            int number = parseElement(tail[0]);
            int mileage = parseElement(tail[1]);
            int extra = 0;
            if (tail.length == 3) extra = parseElement(tail[2]);

            transportInfoMassiv[i][0] = type;
            transportInfoMassiv[i][1] = number;
            transportInfoMassiv[i][2] = mileage;
            transportInfoMassiv[i][3] = extra;

            switch (type) {
                case (100) -> C100_mileage += mileage;
                case (200) -> C200_mileage += mileage;
                case (300) -> C300_mileage += mileage;
                case (400) -> C400_mileage += mileage;
            }
        }

        HashMap<String, Double> fuelCostsByType = new HashMap<>();
        fuelCostsByType.put("C100", (C100_mileage / 100) * C100_FUEL_CONSUMPTION * C100_FUEL_COST);
        fuelCostsByType.put("C200", (C200_mileage / 100) * C200_FUEL_CONSUMPTION * C200_FUEL_COST);
        fuelCostsByType.put("C300", (C300_mileage / 100) * C300_FUEL_CONSUMPTION * C300_FUEL_COST);
        fuelCostsByType.put("C400", (C400_mileage / 100) * C400_FUEL_CONSUMPTION * C400_FUEL_COST);

        HashMap<String, Double> sorted = new LinkedHashMap<>();
            fuelCostsByType.entrySet()
                    .stream()
                    .sorted(Map.Entry.comparingByValue())
                    .forEachOrdered(x -> sorted.put(x.getKey(), x.getValue()));


        for (double value : fuelCostsByType.values()) {
            total_cost += value;
        }
        out.println("Общая стоимость расходов на ГСМ: " + total_cost);
        out.println();

        out.println("Расходы на каждый класс авто:");
        out.println(sorted);
        out.println();

        List<Map.Entry<String,Double>> entryList = new ArrayList<>(sorted.entrySet());
        Map.Entry<String, Double> lastEntry = entryList.get(entryList.size()-1);
        out.println("Тип авто имеющий наименьшую стоимость расходов: " + entryList.get(0));
        out.println("Тип авто имеющий наибольшую стоимость расходов: " + lastEntry);
        out.println();

        out.println("Информация о каждом авто по типам с сортировкой по пробегу: ");
        infoByType(100);
        infoByType(200);
        infoByType(300);
        infoByType(400);

    }
}
