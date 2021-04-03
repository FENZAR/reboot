package edu.reboot.task5;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Timer;
import java.util.TimerTask;

public class SubTask_1 {

    public static void main(String[] args) throws InterruptedException {

        TimerTask task1 = new MessageTask("1 second period: ");
        TimerTask task2 = new MessageTask("5 second period: ");

        Timer timer = new Timer();

        timer.scheduleAtFixedRate(task1, 0, 1000);
        timer.scheduleAtFixedRate(task2, 4000, 5000);

        Thread.sleep(30000);
        timer.cancel();

    }

    public static class MessageTask extends TimerTask {

        private String message;

        public MessageTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println(message
                    + LocalDateTime.ofInstant(Instant.ofEpochMilli(scheduledExecutionTime()),
                    ZoneId.systemDefault()));
        }
    }

}
