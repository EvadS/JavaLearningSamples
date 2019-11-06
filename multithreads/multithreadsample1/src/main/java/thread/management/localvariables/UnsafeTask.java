package thread.management.localvariables;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Каждый поток имеет разное время начала, но когда они заканчиваются, происходит изменение
 * значение атрибута.
 */
public class UnsafeTask implements Runnable {
    private Date startDate;


    @Override
    public void run() {
        startDate=new Date();
        System.out.printf("Starting Thread: %s : %s\n",
                Thread.currentThread().getId(),startDate);
        try {
            TimeUnit.SECONDS.sleep( (int)Math.rint(Math.random()*10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Thread Finished: %s : %s\n",
                Thread.currentThread().getId(),startDate);
    }
}
