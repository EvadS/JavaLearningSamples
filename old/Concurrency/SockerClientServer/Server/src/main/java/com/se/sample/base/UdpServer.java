package com.se.sample.base;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class UdpServer  implements Runnable{

    private static final  Logger log = LogManager.getLogger(UdpServer.class);


    private ExecutorService executor = Executors.newCachedThreadPool(runnable -> {
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.setName("UdpExecutor#" + thread.getId());
        return thread;
    });

    public static final int MAX_UDP_SIZE = 65507;
    private DatagramSocket socket;

    @Override
    public void run() {

        byte[] buf;
        DatagramPacket udp;

        buf = new byte[MAX_UDP_SIZE];
        while (true) {
            buf = new byte[MAX_UDP_SIZE];
            udp = new DatagramPacket(buf, buf.length);

            try {

                socket.receive(udp);
                executor.submit(new UDPHandler(udp));
            } catch (Throwable e) {
                log.error("Can't receive udp packet. ", e);
                socket.close();
            }
        }

    }

    private class UDPHandler implements Runnable {

        private DatagramPacket udp;


        public UDPHandler(DatagramPacket udp) {
            this.udp = udp;
        }

        @Override
        public void run() {


            try {
                int a = 10;

            } catch (IndexOutOfBoundsException e) {

                System.out.println("exeption ex" + e.getMessage());
                return;

            }
        }
    }
}
