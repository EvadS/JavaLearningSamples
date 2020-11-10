package com.se.first.sample;


import com.soapbox.basenode.crypto.CryptoController;
import com.soapbox.basenode.network.protocol.rlpx.subprotocol.video.message.verification.VideoStoreVerificationTask;


public class App {
    public static void main( String[] args ) throws Exception {

        CryptoController controller;

        VideoStoreVerificationTask videoStore =
                new VideoStoreVerificationTask(null,null,null,0,null);

       // Bytes bytes = videoStore.toBytes();


        System.out.println( "Hello World!" );

        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
