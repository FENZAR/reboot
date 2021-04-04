package edu.reboot.task5;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SubTask_1 {

    public static void main(String[] args) throws InterruptedException {

        MessageTask task1 = new MessageTask();
        MessageTask task2 = new MessageTask();
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        executor.scheduleWithFixedDelay(thread1, 0, 1, TimeUnit.SECONDS);
        executor.scheduleWithFixedDelay(thread2, 4, 5, TimeUnit.SECONDS);

        Thread.sleep(30000);
        executor.shutdown();

    }

}
