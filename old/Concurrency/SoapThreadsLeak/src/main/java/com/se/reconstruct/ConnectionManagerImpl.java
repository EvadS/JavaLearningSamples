package com.se.reconstruct;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ConnectionManagerImpl {

    private TcpServer videoTcpServer;
    private Thread peerConnectionsThread;
    private TcpServer blockchainTcpServer;


    public void start() {
        startVideoTcpServer();
        startBlockchainTcpServer();

        startEstablishPeerConnectionsProcess();
    }

    private void startBlockchainTcpServer() {
        startTcpServer(true);

        Thread blockchainTcpServerThread = new Thread(blockchainTcpServer);
        blockchainTcpServerThread.setName("BlockchainTcpServerThread");
        blockchainTcpServerThread.setDaemon(true);
        blockchainTcpServerThread.start();
    }

    private void startVideoTcpServer() {
        startTcpServer(false);

        Thread videoTcpServerThread = new Thread(videoTcpServer);
        videoTcpServerThread.setName("VideoTcpServerThread");
        videoTcpServerThread.setDaemon(true);
        videoTcpServerThread.start();
    }

    private void startEstablishPeerConnectionsProcess() {
        peerConnectionsThread = new Thread(new CreateConnectionsTask());

        peerConnectionsThread.setDaemon(true);
        peerConnectionsThread.setName("PeerConnectionsThread");
        peerConnectionsThread.start();
    }

    private void startTcpServer(boolean isBlockchain) {
        TcpServer tcpServer = null;
        try {
            for (int i = 0; i < 3; i++) {
                tcpServer = new TcpServer();

                if (isBlockchain) {
                    blockchainTcpServer = tcpServer;
                } else {
                    videoTcpServer = tcpServer;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void handle() {
        try {
            String certificateBytes = TcpServer.sendAndGetResponse().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }

    private void createConnection() {
        try {
            String certificateBytes = TcpServer.sendAndGetResponse().get();
            System.out.println("create Connection, got :  " + certificateBytes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class CreateConnectionsTask implements Runnable {


        int connection = 0;

        @Override
        public void run() {
            while (connection < 25) {
                System.out.println("Create connection from Create Connection task ");
                createConnection();

                connection++;
            }
        }
    }
}



