package com.se.sample;

import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECParameterSpec;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class KeyUtils {

    public static final String PATH = "resources";
    public static final String FILE_NAME_KEY_STORE = "keystore.ks";
    public static final String FILE_NAME_PUBLIC_KEY = "public.key";

    private static final String KEYS_ALGORITHM = "EC";
    private static final String PROVIDER = "BC";
    private static final String STD_NAME = "secp256r1";
    private static final String ALIAS_KEY = "keySoapBox";

    private KeyStore keyStore;

    public KeyUtils() {
        try {
            keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        Security.addProvider(new BouncyCastleProvider());
    }

    public void loadKeyStore(String keyStorePassword) {
        try {
            keyStore.load(null, keyStorePassword.toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }
    }

    public void loadKeyStoreFromFile(String keyStorePassword) throws IOException {

        InputStream keyStoreData = null;
        try {
            keyStoreData = new FileInputStream(Paths.get(PATH, FILE_NAME_KEY_STORE).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            keyStore.load(keyStoreData, keyStorePassword.toCharArray());
        } catch (NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }

    public void setPrivateKey(PrivateKey privateKey, X509Certificate cer, String keyPassword) {
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword.toCharArray());
        Certificate[] arreyCert = new Certificate[1];
        arreyCert[0] = cer;
        KeyStore.PrivateKeyEntry privateKeyEntry = new KeyStore.PrivateKeyEntry(privateKey, arreyCert);
        try {
            keyStore.setEntry(ALIAS_KEY, privateKeyEntry, entryPassword);
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public void saveKeyStore(String keyStorePassword) {
        new File(Paths.get(PATH).toString()).mkdir();
        FileOutputStream keyStoreOutputStream = null;
        try {
            keyStoreOutputStream = new FileOutputStream(Paths.get(PATH, FILE_NAME_KEY_STORE).toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            keyStore.store(keyStoreOutputStream, keyStorePassword.toCharArray());
            keyStoreOutputStream.close();
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException e) {
            e.printStackTrace();
        }
    }

    public KeyPair generateKeyPair() {
        ECParameterSpec ecSpec = ECNamedCurveTable.getParameterSpec(STD_NAME);
        KeyPairGenerator generator = null;
        try {
            generator = KeyPairGenerator.getInstance(KEYS_ALGORITHM, PROVIDER);
            generator.initialize(ecSpec, new SecureRandom());
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        }
        return generator.generateKeyPair();
    }

    public void savePublicKey(PublicKey publicKey) {
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKey.getEncoded());
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(Paths.get(PATH, FILE_NAME_PUBLIC_KEY).toString());
            fos.write(x509EncodedKeySpec.getEncoded());
            fos.close();
        } catch ( IOException e) {
            e.printStackTrace();
        }
    }

    private KeyPair getKeyPair(String keyPassword) throws UnrecoverableEntryException {
        KeyStore.ProtectionParameter entryPassword = new KeyStore.PasswordProtection(keyPassword.toCharArray());
        KeyStore.PrivateKeyEntry privateKeyEntry = null;
        PublicKey publicKey = null;
        try {
            privateKeyEntry = (KeyStore.PrivateKeyEntry) keyStore.getEntry(ALIAS_KEY, entryPassword);
            publicKey = keyStore.getCertificate(ALIAS_KEY).getPublicKey();
        } catch (NoSuchAlgorithmException | KeyStoreException  e) {
            e.printStackTrace();
        }
        PrivateKey privateKey = privateKeyEntry.getPrivateKey();
        return new KeyPair(publicKey, privateKey);
    }

    public KeyPair loadKeyPair(String keyStorePassword) throws IOException, UnrecoverableEntryException {
        loadKeyStoreFromFile(keyStorePassword);
        return getKeyPair(keyStorePassword);
    }

    public PublicKey loadPublicKey(String publicKeyPath){
        PublicKey publicKey = null;
        try {
            File filePublicKey = new File(publicKeyPath);
            FileInputStream fis = new FileInputStream(publicKeyPath);
            byte[] encodedPublicKey = new byte[(int) filePublicKey.length()];
            fis.read(encodedPublicKey);
            fis.close();
            KeyFactory keyFactory = KeyFactory.getInstance(KEYS_ALGORITHM);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(
                    encodedPublicKey);
            publicKey = keyFactory.generatePublic(publicKeySpec);
        } catch (InvalidKeySpecException | IOException | NoSuchAlgorithmException e) {

        }
        return publicKey;
    }
}