package com.se.sample;

/**
 * Когда клиент подключается, сервер порождает поток, предназначенный только для этого клиента, для чтения, ввода
 * заглавных букв и ответа. Сервер может одновременно прослушивать и обслуживать других клиентов, поэтому мы имеем истинный параллелизм.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * A server program which accepts requests from clients to capitalize strings. When
 * a client connects, a new thread is started to handle it. Receiving client data,
 * capitalizing it, and sending the response back is all done on the thread, allowing
 * much greater throughput because more clients can be handled concurrently.
 */
public class CapitalizeServer {

    /**
     * Runs the server. When a client connects, the server spawns a new thread to do
     * the servicing and immediately returns to listening. The application limits the
     * number of threads via a thread pool (otherwise millions of clients could cause
     * the server to run out of resources by allocating too many threads).
     */
    public static void main(String[] args) throws Exception {
        try {
            ServerSocket listener = new ServerSocket(59898);
            System.out.println("The capitalization server is running...");
            ExecutorService pool = Executors.newFixedThreadPool(20);

            while (true) {
                pool.execute(new Capitalizer(listener.accept()));
            }
        }
        catch (Exception ex){
            System.out.println("exception " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static class Capitalizer implements Runnable {
        private Socket socket;

        Capitalizer(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            System.out.println("Connected: " + socket);
            try {
                Scanner in = new Scanner(socket.getInputStream());
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                while (in.hasNextLine()) {
                    String input = in.nextLine();

                    System.out.println("Got string " + input);
                    if(input.equals("exit")){
                        throw  new Exception("exit");
                    }
                    out.println(input.toUpperCase());
                }
            } catch (Exception e) {
                System.out.println("Error:" + socket);
            } finally {
//                try {
//                    socket.close(); } catch (IOException e) {}

                System.out.println("Closed: " + socket);
            }
        }
    }
}
