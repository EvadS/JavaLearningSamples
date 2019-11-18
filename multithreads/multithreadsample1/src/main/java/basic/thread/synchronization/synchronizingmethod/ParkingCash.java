package basic.thread.synchronization.synchronizingmethod;

public class ParkingCash {

    private static final int cost=2;
    private long cash;

    public ParkingCash() {
        cash=0;
    }

    public synchronized void vehiclePay() {
        cash+=cost;
    }

    /**
     * write the value of the cash
     * attribute in the console and reinitialize it to zero:
     */
    public void close() {
        System.out.printf("Closing accounting");
        long totalAmount;
        synchronized(this){totalAmount=cash;
        cash=0;}
        System.out.printf("The total amount is : %d",
                totalAmount);
    }
}

