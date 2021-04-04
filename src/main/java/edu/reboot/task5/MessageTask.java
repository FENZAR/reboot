package edu.reboot.task5;

import java.time.LocalDateTime;

public class MessageTask implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + LocalDateTime.now());
    }

}
