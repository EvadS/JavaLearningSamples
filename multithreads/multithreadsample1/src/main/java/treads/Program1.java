package treads;

import treads.JThread;

public class Program1 {
    public static void main(String[] args) {

        System.out.println("Main thread started...");
        new JThread("JThread").start();
        System.out.println("Main thread finished...");
    }
}
