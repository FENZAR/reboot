package edu.reboot.task2;

import java.util.*;

import static java.lang.System.out;

public class Task2 {

    private static final double C100_FUEL_CONSUMPTION = 12.5;
    private static final double C200_FUEL_CONSUMPTION = 12.0;
    private static final double C300_FUEL_CONSUMPTION = 11.5;
    private static final double C400_FUEL_CONSUMPTION = 20.0;

    private static final double C100_FUEL_COST = 46.10;
    private static final double C200_FUEL_COST = 48.90;
    private static final double C300_FUEL_COST = 47.50;
    private static final double C400_FUEL_COST = 48.90;

    private static double C100_mileage;
    private static double C200_mileage;
    private static double C300_mileage;
    private static double C400_mileage;

    private static String[] GSM = {
            "C100_1-100",
            "C200_1-120-1200",
            "C300_1-120-30",
            "C400_1-80-20",
            "C100_2-50",
            "C200_2-40-1000",
            "C300_2-200-45",
            "C400_2-80-19",
            "C100_3-10",
            "C200_3-170-1100",
            "C300_3-150-29",
            "C400_3-100-28",
            "C100_1-300",
            "C200_1-100-750",
            "C300_1-32-15"
    };

    private static HashMap<String, Vehicle> vehiclesInfoMap = new HashMap<>();

    private static int parseElement(String element) {
        try {
            return Integer.parseInt((element));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void infoByType(String type) {

        Comparator<Vehicle> vcomp = new VehicleMileageComparator().thenComparing(new VehicleExtraComparator());
        TreeSet<Vehicle> vehicles = new TreeSet<>(vcomp);

        Iterator it = vehiclesInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(pair.getKey().toString().substring(0, 4).equals(type)) {
                vehicles.add((Vehicle) pair.getValue());
            }
        }
        out.println(vehicles);
    }

    private static void parseInputString(String input) {
        // Строку формата "C200_1-100-750" забиваем на 2 части по разделителю "_"
        String[] splitStr = input.split("_");
        // Разбиваем вторую часть по разделителю "-"
        String[] tail = (splitStr[1]).split("-");

        String type = splitStr[0].substring(0, 4);
        int number = parseElement(tail[0]);
        int mileage = parseElement(tail[1]);
        int extra = 0;
        if (tail.length == 3) extra = parseElement(tail[2]);

        // Считаем пробег по типу
        switch (type) {
            case ("C100") -> C100_mileage += mileage;
            case ("C200") -> C200_mileage += mileage;
            case ("C300") -> C300_mileage += mileage;
            case ("C400") -> C400_mileage += mileage;
        }

        String key = type + number;
        Vehicle temp = vehiclesInfoMap.get(key);

        // Если объекта еще нет - создаем новый, иначе суммируем пробег и доп. параметр
        if(temp == null) {
            switch (type) {
                case ("C100") -> {
                    vehiclesInfoMap.put(key, new Car(type, number, mileage));
                }
                case ("C200") -> {
                    vehiclesInfoMap.put(key, new Truck(type, number, mileage, extra));
                }
                case ("C300") -> {
                    vehiclesInfoMap.put(key, new PassengerTransport(type, number, mileage, extra));
                }
                case ("C400") -> {
                    vehiclesInfoMap.put(key, new HeavyMachinery(type, number, mileage, extra));
                }
            }
        } else {
            temp.setMileage(temp.getMileage() + mileage);
            temp.setExtra(temp.getExtra() + extra);
        }

    }

    public static void main(String[] args) {

        double total_cost = 0;

        // Формирование массива объектов
        for (int i = 0; i < GSM.length; i++) {
            parseInputString(GSM[i]);
        }

        // Рассчет стоимости по типу
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

        // Общая стоимость
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
        infoByType("C100");
        infoByType("C200");
        infoByType("C300");
        infoByType("C400");
    }
}
