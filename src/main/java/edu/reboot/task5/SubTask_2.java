package edu.reboot.task5;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SubTask_2 {

    public static void main(String[] args) throws InterruptedException {

        int minCustomerNumber = 3;
        int maxCustomerNumber = 9;

        Random random = new Random();
        int customersNumber = random.nextInt(maxCustomerNumber - minCustomerNumber) + minCustomerNumber;

        int producerNumber = customersNumber - 2;

        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(customersNumber);
        ScheduledExecutorService executor2 = Executors.newScheduledThreadPool(producerNumber);

        Stock stock = new Stock(producerNumber);

        System.out.println("Количество товара на складе до открытия: " + stock.getQuantityOfGoods());
        System.out.println("Количество покупателей: " + customersNumber);
        System.out.println("Количество поставщиков: " + producerNumber);

        // запускаем покупателей
        for (int i = 0; i < customersNumber; i++) {
            executor1.scheduleWithFixedDelay(new Thread(new Customer(stock), "Customer-" + i), 0, 1, TimeUnit.SECONDS);
        }

        // запускаем поставщиков
        for (int i = 0; i < producerNumber; i++) {
            executor2.scheduleWithFixedDelay(new Thread(new Producer((random.nextInt(2) + 1), stock), "Producer-"+i), 0, 1, TimeUnit.SECONDS);
        }

        Thread.sleep(30000);
        executor1.shutdown();
        executor2.shutdown();

    }

}
