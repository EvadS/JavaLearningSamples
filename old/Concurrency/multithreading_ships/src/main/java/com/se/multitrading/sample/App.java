package com.se.multitrading.sample;

import com.se.multitrading.sample.ships.types.Type;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Available number of cores: " + Runtime.getRuntime().availableProcessors());

        Tunnel tunnel = new Tunnel();

        /**
         * количество корабликов, необходимое для генераций потоком.
         */
        ShipGenerator shipGenerator = new ShipGenerator(tunnel, 10);

        //создаем 3 объекта PierLoader для погрузки 3 типов корабля
        PierLoader pierLoader1 = new PierLoader(tunnel, Type.DRESS);
        PierLoader pierLoader2 = new PierLoader(tunnel, Type.BANANA);
        PierLoader pierLoader3 = new PierLoader(tunnel, Type.MEAL);


        //Сначала создаем пул потоков для запуска задач. К
        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        service.execute(shipGenerator);
        service.execute(pierLoader1);
        service.execute(pierLoader2);
        service.execute(pierLoader3);

        service.shutdown();
    }
}
