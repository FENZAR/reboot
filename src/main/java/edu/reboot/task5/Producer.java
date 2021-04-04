package edu.reboot.task5;

import java.time.LocalDateTime;

public class Producer implements Runnable {

    private int cargoVolume; // Объем поставки
    private Stock stock;

    public Producer(int cargoVolume, Stock stock) {
        this.cargoVolume = cargoVolume;
        this.stock = stock;
    }

    @Override
    public void run() {
        StringBuilder message = new StringBuilder(LocalDateTime.now() + " " + Thread.currentThread().getName());
        message.append(" Поставщик " + " привез " + cargoVolume + " едениц товара. ");
        stock.setQuantityOfGoods(stock.getQuantityOfGoods() + cargoVolume);
        message.append("Товара на складе: " + stock.getQuantityOfGoods());
        System.out.println(message.toString());
    }
}
