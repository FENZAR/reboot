package edu.reboot.task5;

import java.time.LocalDateTime;
import java.util.TimerTask;

public class Customer extends TimerTask {

    private Stock stock;

    public Customer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        StringBuilder message = new StringBuilder(LocalDateTime.now() + " " + Thread.currentThread().getName());

        if (stock.getQuantityOfGoods() < 1) {
            message.append(" Товара нет, покупатель ушел");
        } else {
            stock.setQuantityOfGoods(stock.getQuantityOfGoods() - 1);
            message.append(" Покупатель купил 1 товар. ");
            message.append("Осталось на складе: " + stock.getQuantityOfGoods());
        }

        System.out.println(message.toString());
    }
}
