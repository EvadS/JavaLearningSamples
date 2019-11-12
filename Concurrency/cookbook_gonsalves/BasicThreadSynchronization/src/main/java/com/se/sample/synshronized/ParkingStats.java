package com.se.sample.synshronized;

public class ParkingStats {

    private long numberCars;
    private long numberMotorcycles;
    private ParkingCash cash;

    public ParkingStats(ParkingCash cash) {
        numberCars = 0;
        numberMotorcycles = 0;
        this.cash = cash;
    }

    public long getNumberCars() {
        return numberCars;
    }

    public void setNumberCars(long numberCars) {
        this.numberCars = numberCars;
    }

    public long getNumberMotorcycles() {
        return numberMotorcycles;
    }

    public void setNumberMotorcycles(long numberMotorcycles) {
        this.numberMotorcycles = numberMotorcycles;
    }

    public void carComeIn() {
        numberCars++;
    }

    public void carGoOut() {
        numberCars--;
        cash.vehiclePay();
    }

    public void motoComeIn() {
        numberMotorcycles++;
    }

    public void motoGoOut() {
        numberMotorcycles--;
        cash.vehiclePay();
    }
}