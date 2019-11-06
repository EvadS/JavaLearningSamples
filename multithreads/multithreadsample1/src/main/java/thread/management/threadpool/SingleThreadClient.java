package thread.management.threadpool;

import java.time.LocalTime;

public class SingleThreadClient {
    public static void main(String[] args) {
        Counter counter = new Counter();
        LocalTime localTime = LocalTime.now();
        System.out.println("start " + localTime.toString());
        long start = System.nanoTime();

        double value = 0;
        for (int i = 0; i < 400; i++) {
            value += counter.count(i);
        }

        localTime = LocalTime.now();
        System.out.println("stop  " + localTime.toString());

        System.out.println(String.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value));
    }
}
