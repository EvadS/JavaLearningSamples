package treads;

public class Program2 {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        for (int i = 1; i < 6; i++)
            new JThread("JThread " + i).start();
        System.out.println("Main thread finished...");
    }
}

class CommonResource {

    int x;

    synchronized void increment() {
        x = 1;
        for (int i = 1; i < 5; i++) {
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}

class CountThread implements Runnable {

    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    public void run() {
        res.increment();
    }
}
