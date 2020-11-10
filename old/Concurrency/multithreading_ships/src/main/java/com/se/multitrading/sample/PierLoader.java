package com.se.multitrading.sample;

import com.se.multitrading.sample.ships.Ship;
import com.se.multitrading.sample.ships.types.Type;

public class PierLoader implements Runnable {
    private Tunnel tunnel;
    private Type shipType;

    public PierLoader(Tunnel tunnel, Type shipType) {
        this.tunnel = tunnel;
        this.shipType =shipType;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Thread.currentThread().setName("Loader "+shipType);

                //Time to load the goods
                Thread.sleep(500);
                Ship ship = tunnel.get(shipType);
                if(ship!=null)
                    while (ship.countCheck()){
                        //о для эмуляций работы погрузчиков и генераций кораблей
                        // (якобы нужно время для загрузки товарами и корабли должны приплыть), а не для задержки их с целью
                        // подогнать под другие потоки.
                        Thread.sleep(100);
                        ship.add(10);
                        System.out.println(ship.getCount() + " Loaded ship. " + Thread.currentThread().getName());
                    }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
