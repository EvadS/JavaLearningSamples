package com.se.multitrading.sample;

import com.se.multitrading.sample.ships.Ship;
import com.se.multitrading.sample.ships.types.Size;
import com.se.multitrading.sample.ships.types.Type;

import java.util.Random;

/**
 * Небольшое отступление.  необходимо добавить задачу для потока, так как многие ошибочно полагают, что реализовав
 * интерфейс Runnable они создают поток. На самом деле они создают задачу для потока. Другими словами, создав
 * 1000 классов, реализующих интерфейс Runnable не значит создать 1000 потоков. Это значит создать 1000 задач.
 * А количество потоков, которые будут исполнять эти задачи будет зависеть от количества ядер на вашей машине.
 */
public class ShipGenerator implements Runnable {

    private Tunnel tunnel;
    private int shipCount;

    /**
     *
     * @param tunnel
     * @param shipCount количество кораблей, необходимых для генераций.
     */
    public ShipGenerator(Tunnel tunnel, int shipCount) {
        this.tunnel = tunnel;
        this.shipCount = shipCount;
    }

    /**
     *  непосредственно будет исполняться потоком.
     */
    @Override
    public void run() {
        int count = 0;
        while (count < shipCount) {
            Thread.currentThread().setName(" Generator ship");
            count++;
            tunnel.add(new Ship(getRandomSize(), getRandomType()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private Type getRandomType() {
        Random random = new Random();
        return Type.values()[random.nextInt(Type.values().length)];
    }

    private Size getRandomSize() {
        Random random = new Random();
        return Size.values()[random.nextInt(Size.values().length)];
    }
}