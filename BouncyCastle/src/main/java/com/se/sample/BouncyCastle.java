package com.se.sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import java.util.Date;

import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.X509Extensions;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.cert.X509v3CertificateBuilder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.x509.X509V3CertificateGenerator;

import javax.security.auth.x500.X500Principal;

public class BouncyCastle {

    public static final String FILE_NAME = "X509.cer";
    public static final String PATH_SAVE = "new_certificates";
    private static final String KEYS_ALGORITHM = "EC";

    public static void main(String[] args) throws CertificateEncodingException, InvalidKeyException, IllegalStateException, NoSuchProviderException, NoSuchAlgorithmException, SignatureException, IOException {
        X509Certificate selfSignedX509Certificate = new BouncyCastle().generateSelfSignedX509Certificate();

        byte[] data = selfSignedX509Certificate.getEncoded();
        String name = "public_sertificate" + "_" + FILE_NAME;

        File yourFile = new File(name);
        if(!yourFile.exists()) {
            yourFile.createNewFile();
        }

        String path="Folder directory";
        File file = new File(PATH_SAVE);

        if (!file.exists()) {
            System.out.print("No Folder");
            file.mkdir();
            System.out.print("Folder created");
        }

        FileOutputStream fos = new FileOutputStream(Paths.get(PATH_SAVE, name).toString()  ,true );

        fos.write(data);
        fos.close();

        //-----------------------------
        PublicKey publickey =  selfSignedX509Certificate.getPublicKey();
        fos = new FileOutputStream(Paths.get(PATH_SAVE, "public_key").toString()  ,true );

        fos.write(publickey.getEncoded());
        fos.close();

        fos = new FileOutputStream(Paths.get(PATH_SAVE, "public_key").toString()  ,true );
        fos.write(data);
        fos.close();

        System.out.println(selfSignedX509Certificate);
    }

    public X509Certificate generateSelfSignedX509Certificate() throws CertificateEncodingException, InvalidKeyException, IllegalStateException,
            NoSuchProviderException, NoSuchAlgorithmException, SignatureException, NoSuchProviderException, NoSuchAlgorithmException, IOException {
        addBouncyCastleAsSecurityProvider();

        // generate a key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ECDH", "BC");
       // generator = KeyPairGenerator.getInstance(KEYS_ALGORITHM, PROVIDER);
        keyPairGenerator.initialize(4096, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        PrivateKey key = keyPair.getPrivate();
        //Sign
        PrivateKey privKey = (PrivateKey) key;
        Signature signature = Signature.getInstance("SHA1WithRSA", "BC");
        signature.initSign(privKey);
        signature.update("text".getBytes());

        //---------------------------------------------------------
        FileOutputStream fos = new FileOutputStream(Paths.get(PATH_SAVE, "private_key").toString()  ,true );

        fos.write(privKey.getEncoded());
        fos.close();
        //--------------------------------------------------------
        // build a certificate generator
        X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
        X500Principal dnName = new X500Principal("cn=example");

        X509v3CertificateBuilder certificateBuilder;

        // add some options
        certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
        certGen.setSubjectDN(new X509Name("dc=name"));
        certGen.setIssuerDN(dnName); // use the same
        // yesterday
        certGen.setNotBefore(new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));
        // in 2 years
        certGen.setNotAfter(new Date(System.currentTimeMillis() + 2 * 365 * 24 * 60 * 60 * 1000));
        certGen.setPublicKey(keyPair.getPublic());
        certGen.setSignatureAlgorithm("SHA256WithRSAEncryption");
        certGen.addExtension(X509Extensions.ExtendedKeyUsage, true,
                new ExtendedKeyUsage(KeyPurposeId.id_kp_timeStamping));

        // finally, sign the certificate with the private key of the same KeyPair
        X509Certificate cert = certGen.generate(keyPair.getPrivate(), "BC");


        return cert;
    }

    public void addBouncyCastleAsSecurityProvider() {
        Security.addProvider( new BouncyCastleProvider());


    }
}
