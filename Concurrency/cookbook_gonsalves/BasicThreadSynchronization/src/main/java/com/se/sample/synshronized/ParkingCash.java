package com.se.sample.synshronized;


/**
 * store the total amount of money earned by providing this parking service:
 */
public class ParkingCash {

    private static final int cost = 2;
    private long cash;

    public ParkingCash() {
        cash = 0;
    }

    /**
     * a vehicle (a car or motorcycle) leaves the parking area.
     */
    public void vehiclePay() {
        cash += cost;
    }

    /**
     * write the value of the cash
     * attribute in the console and reinitialize it to zero:
     */

    public void close() {
        System.out.printf("Closing accounting");
        long totalAmmount;
        synchronized (this) {
            totalAmmount=cash;
            cash=0;
        }
        System.out.printf("The total amount is : %d",totalAmmount);
    }
}


