package com.se.multitrading.sample;

import com.se.multitrading.sample.ships.Ship;
import com.se.multitrading.sample.ships.types.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * Туннель хранит в себе кораблики, делается это при помощи List.
 * Вместительность туннели 5 корабликов.
 */
public class Tunnel {
    private static final int maxShipsInTunel = 5;
    private static final int minShipsInTunel = 0;
    private List<Ship> store;
    private int shipsCounter = 0;

    public Tunnel() {
        store = new ArrayList<>();
    }

    public synchronized boolean add(Ship element) {

        try {
            if (shipsCounter < maxShipsInTunel) {
                //пробудить и сказать, чтобы они вновь шли работать
                //переключить поток из состояния WAITING в RUNNABLE.
                notifyAll();
                store.add(element);
                String info = String.format("%s + The ship arrived in the tunnel: %s %s %s", store.size(), element.getType(), element.getSize(), Thread.currentThread().getName());
                System.out.println(info);
                shipsCounter++;

            } else {
                System.out.println(store.size() + "> There is no place for a ship in the tunnel: " + Thread.currentThread().getName());
                //потоки не должны быть активными если нет задач.
                //поток должен остановить свою деятельность и подождать
                // чтобы остановить поток и снять mutex мы вызываем wait()
                wait();
                return false;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * достает и удаляет из списка кораблик по необходимому ему типу.
     *
     * @param shipType
     * @return
     */
    public synchronized Ship get(Type shipType) {

        try {
            if (shipsCounter > minShipsInTunel) {
                notifyAll();
                for (Ship ship : store) {
                    if (ship.getType() == shipType) {
                        shipsCounter--;
                        System.out.println(store.size() + "- The ship is taken from the tunnel: " + Thread.currentThread().getName());
                        store.remove(ship);
                        return ship;
                    }
                }
            }

            System.out.println("0 < There are no ships in the tunnel");
            wait();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

}
