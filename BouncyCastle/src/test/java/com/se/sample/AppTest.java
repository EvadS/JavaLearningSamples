package com.se.sample;

import static org.junit.Assert.assertTrue;

import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessable;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Before;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.BASE64Encoder;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private static final int ASYNCH_KEY_SIZE = 256;
    private static final int SYNCH_KEY_SIZE = 128;
    private static final String AGREEMENT_ALGORITHM = "ECDH";
    private static final String CERTIFICATE_FORMAT = "X.509";
    private static final String HASH_ALGORITHM = "SHA-512";
    private static final String KEY_ALGORITHM = "EC";
    private static final String MAC_ALGORITHM = "HmacSHA512";
    private static final String SIGNATURE_ALGORITHM = "SHA512withECDSA";
    private static final String ASYNC_ALGORITHM = "RSA";
    private static final String ASYNC_ALGORITHM_MODE = "ECB";
    private static final String ASYNC_ALGORITHM_PADDING = "OAEPWithSHA-256AndMGF1Padding";
    private static final String SYNC_ALGORITHM = "AES";
    private static final String SYNC_ALGORITHM_MODE = "CTR";
    private static final String SYNC_ALGORITHM_PADDING = "NoPadding";

    public static String path = "new_certificates/";
    //File.separator + "opt" + File.separator + "CryptoChatServer" + File.separator; // Server

    private static ArrayList<X509Certificate> caCertificates = new ArrayList<>();
    private static CertificateFactory certificateFactory;
    private static Cipher asyncCipher;
    private static Cipher syncCipher;
    private static KeyAgreement ka;
    private static KeyFactory akf;
    private static KeyFactory kf;
    private static KeyPairGenerator kpg;
    private static Mac mac;
    private static PrivateKey delayPrivateKey;
    private static PrivateKey privateKey;
    private static SecureRandom rand = new SecureRandom();
    private static Signature signature;
    private static X509Certificate serverCertificate;
    private static X509Certificate serverDelayCertificate;
    private static X509CRL crl;

    Logger log = Logger.getLogger(AppTest.class.getName());
    /**
     * Rigorous Test :-)
     */
    @Before
    public  void init() throws CertificateException, NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, IOException, CMSException, InvalidKeySpecException {
        java.security.Security.addProvider(new BouncyCastleProvider());
        rand.nextInt(); // фактический запуск генерации псевдо-случайных чисел
        certificateFactory = CertificateFactory.getInstance(CERTIFICATE_FORMAT);
        ka = KeyAgreement.getInstance(AGREEMENT_ALGORITHM);
        akf = KeyFactory.getInstance(ASYNC_ALGORITHM);
        kf = KeyFactory.getInstance(KEY_ALGORITHM);
        kpg = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        kpg.initialize(ASYNCH_KEY_SIZE);
        signature = Signature.getInstance(SIGNATURE_ALGORITHM);
        asyncCipher = Cipher.getInstance(ASYNC_ALGORITHM + "/" + ASYNC_ALGORITHM_MODE + "/" + ASYNC_ALGORITHM_PADDING, "BC");
        syncCipher = Cipher.getInstance(SYNC_ALGORITHM + "/" + SYNC_ALGORITHM_MODE + "/" + SYNC_ALGORITHM_PADDING, "BC");
        mac = Mac.getInstance(MAC_ALGORITHM);

        StringBuilder logString = new StringBuilder( );

        // Загружается сертификат сервера для аутентификации
        byte[] temp = readFromFile(path + "public_sertificate_X509.cer");
        serverCertificate = parseCertificate(temp);
        logString = new StringBuilder();
        logString.append("Server certificate loaded OK");


        // Загружается приватный ключ сервера для шифрования
       temp = readFromFile(path + "private_key");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(temp);
       // delayPrivateKey = akf.generatePrivate(privateKeySpec);
        privateKey = kf.generatePrivate(privateKeySpec);
      //  StringBuilder logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("Server private key loaded OK");


        byte[] signature = serverCertificate.getSignature();
        System.out.println(Base64.encode(signature));

      //  ServerLogger.log(Level.FINE, logString);



    }

    private static byte[] readFromFile(String fileName) throws IOException {
        byte[] result;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(new File(fileName));
            bis = new BufferedInputStream(fis);
            result = new byte[fis.available()];
            bis.read(result);
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public static X509Certificate parseCertificate(byte[] bytes) {
        X509Certificate certificate = null;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            certificate = (X509Certificate) certificateFactory.generateCertificate(bais);
        } catch (Exception ex) {
        }
        return certificate;
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
