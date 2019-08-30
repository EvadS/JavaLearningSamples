package my.pack;


import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.json.Json;
import javax.json.JsonObject;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.asn1.x500.style.IETFUtils;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

/**
 *
 * @author Sergey Shendenkov <sshendenkov@s-pro.io>
 */
public class Security {

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

    //public static String path = File.separator + "home" + File.separator + "web-dev" + File.separator + "s-pro" + File.separator + "projects" + File.separator + "CryptoChatServer" + File.separator; // Develop
    //public static String path = "D:" + File.separator + "work" + File.separator + "CryptoChatServer" + File.separator; // Home
    public static String path = File.separator + "opt" + File.separator + "CryptoChatServer" + File.separator; // Server

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

    public static void init() throws IOException, CertificateException, InvalidKeySpecException, NoSuchProviderException, NoSuchAlgorithmException, NoSuchPaddingException {
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

        // Загружается приватный ключ сервера для аутентификации
        byte[] temp = readFromFile(path + "serverPrivate.key");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(temp);
        privateKey = kf.generatePrivate(privateKeySpec);
        StringBuilder logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("Server private key loaded OK");
        ServerLogger.log(Level.FINE, logString);

        // Загружается сертификат сервера для аутентификации
        temp = readFromFile(path + "serverCertificate.cer");
        serverCertificate = parseCertificate(temp);
        logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("Server certificate loaded OK");
        ServerLogger.log(Level.FINE, logString);
        
        // Загружается приватный ключ сервера для шифрования
        temp = readFromFile(path + "serverDelayPrivate.key");
        privateKeySpec = new PKCS8EncodedKeySpec(temp);
        delayPrivateKey = akf.generatePrivate(privateKeySpec);
        logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("Server delay private key loaded OK");
        ServerLogger.log(Level.FINE, logString);

        // Загружается сертификат сервера для шифрования
        temp = readFromFile(path + "serverDelayCertificate.cer");
        serverDelayCertificate = parseCertificate(temp);
        logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("Server delay certificate loaded OK");
        ServerLogger.log(Level.FINE, logString);

        // Загружается список сертификатов CA
        getCACertificates(null);
        if (caCertificates.isEmpty()) {
            throw new IOException("CA certificates now found");
        }
        logString = new StringBuilder(ServerLogger.TEXT_BOLD_GREEN);
        logString.append("CA CERTIFICATES loaded OK");
        ServerLogger.log(Level.FINE, logString);
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
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                }
            }
        }
        return result;
    }

    public static ArrayList<String> getCACertificates(ArrayList<String> hashes) {
        ArrayList<String> result = new ArrayList<>();
        boolean found;
        byte[] temp;
        String cert;
        String hash;
        X509Certificate certificate;
        caCertificates.clear();
        for (File file : new File(path + "caCertificates").listFiles()) {
            try {
                temp = readFromFile(path + "caCertificates" + File.separator + file.getName());
                certificate = parseCertificate(temp);
                caCertificates.add(certificate);
                System.out.println("CACertificate: " + certificate);
                cert = convertCertificate(certificate);
                hash = getHash(cert);
                if (hashes == null) {
                    result.add(cert);
                } else {
                    found = false;
                    for (String h : hashes) {
                        if (h.equals(hash)) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        result.add(cert);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
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

    public static X509Certificate parseCertificate(String str) {
        X509Certificate certificate = null;
        try (ByteArrayInputStream bais = new ByteArrayInputStream(Base64.getDecoder().decode(str))) {
            certificate = (X509Certificate) certificateFactory.generateCertificate(bais);
        } catch (Exception ex) {
        }
        return certificate;
    }

    public static String convertCertificate(X509Certificate certificate) {
        String result = null;
        try {
            result = Base64.getEncoder().encodeToString(certificate.getEncoded());
        } catch (CertificateEncodingException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static PublicKey parsePublicKey(String str) throws InvalidKeySpecException {
        X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(str));
        return kf.generatePublic(publicKeySpec);
    }

    public static PublicKey getPublicKeyFromCSR(String csrString) throws IOException {
        return new JcaPEMKeyConverter().getPublicKey(new PKCS10CertificationRequest(Base64.getDecoder().decode(csrString)).getSubjectPublicKeyInfo());
    }

    public static String getLoginFromCSR(String csrString) {
        String result = "";
        try {
            System.out.println("CSR string: " + csrString);
            PKCS10CertificationRequest req = new PKCS10CertificationRequest(Base64.getDecoder().decode(csrString));
            result = IETFUtils.valueToString(req.getSubject().getRDNs(BCStyle.CN)[0].getFirst().getValue());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static String getLoginFromCertificate(String certificateString) {
        String result = "";
        try {
            result = IETFUtils.valueToString(new JcaX509CertificateHolder(parseCertificate(certificateString)).getSubject().getRDNs(BCStyle.CN)[0].getFirst().getValue());
        } catch (CertificateEncodingException ex) {
        }
        return result;
    }

    public static void verifyCertificate(String certificateString) throws CertificateException {
        if (certificateString == null) {
            throw new CertificateException("Where is no certificate");
        }
        X509Certificate certificate = parseCertificate(certificateString);
        certificate.checkValidity();
        if (crl != null && crl.isRevoked(certificate)) {
            throw new CertificateException("CERTIFICATE revoked");
        }
        boolean good = false;
        for (X509Certificate caCertificate : caCertificates) {
            try {
                signature.initVerify(caCertificate);
                signature.update(certificate.getTBSCertificate());
                signature.verify(certificate.getSignature());
                good = true;
                break;
            } catch (SignatureException | InvalidKeyException ex) {
            }
        }
        if (!good) {
            throw new CertificateException("CERTIFICATE wrong");
        }
    }

    public static String createSignature(String signString) {
        String result = null;
        try {
            signature.initSign(privateKey, rand);
            signature.update(signString.getBytes(StandardCharsets.UTF_8));
            result = Base64.getEncoder().encodeToString(signature.sign());
        } catch (InvalidKeyException | SignatureException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    public static void verifySignature(PublicKey publicKey, String verifyString, String signatureString) throws SignatureException, CertificateException {
        if (publicKey == null) {
            throw new CertificateException("Where is no certificate");
        }
        try {
            signature.initVerify(publicKey);
            signature.update(verifyString.getBytes(StandardCharsets.UTF_8));
            signature.verify(Base64.getDecoder().decode(signatureString));
        } catch (InvalidKeyException ex) {
            throw new SignatureException(ex);
        }
    }

    public static String getCertificate() {
        String result = null;
        try {
            result = Base64.getEncoder().encodeToString(serverCertificate.getEncoded());
        } catch (CertificateEncodingException ex) {
        }
        return result;
    }
    
    public static String getDelayCertificate() {
        String result = null;
        try {
            result = Base64.getEncoder().encodeToString(serverDelayCertificate.getEncoded());
        } catch (CertificateEncodingException ex) {
        }
        return result;
    }

    public static KeyPair generateKeyPair() {
        return kpg.generateKeyPair();
    }

    public static SharedSecret generateSharedSecret(PrivateKey privateKey, PublicKey incomingKey) throws InvalidKeyException, NoSuchAlgorithmException {
        ka.init(privateKey);
        ka.doPhase(incomingKey, true);
        MessageDigest hash = MessageDigest.getInstance(HASH_ALGORITHM);
        hash.update(ka.generateSecret());
        return new SharedSecret(hash.digest(), SYNC_ALGORITHM, SYNCH_KEY_SIZE);
    }

    public static String asyncDecrypt(String encrypted) {
        String decrypted = null;
        System.out.println("Encrypted async: " + encrypted);
        try {
            asyncCipher.init(Cipher.DECRYPT_MODE, delayPrivateKey);
            decrypted = new String(asyncCipher.doFinal(Base64.getDecoder().decode(encrypted)), "UTF-8");
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
        System.out.println("Decrypted async: " + decrypted);
        return decrypted;
    }
    
    public static String syncEncrypt(SharedSecret sharedSecret, String plain) {
        String encrypted = null;
        System.out.println("Plain: " + plain);
        try {
            syncCipher.init(Cipher.ENCRYPT_MODE, sharedSecret.getSecretKey(), sharedSecret.getIv());
            encrypted = Base64.getEncoder().encodeToString(syncCipher.doFinal(plain.getBytes(StandardCharsets.UTF_8)));
        } catch (IllegalBlockSizeException ex) {
            ex.printStackTrace();
        } catch (BadPaddingException ex) {
            ex.printStackTrace();
        } catch (InvalidKeyException ex) {
            ex.printStackTrace();
        }
        System.out.println("Encrypted: " + encrypted);
        return encrypted;
    }

    public static String syncDecrypt(SharedSecret sharedSecret, String encrypted) {
        String decrypted = null;
        System.out.println("Encrypted sync: " + encrypted);
        try {
            syncCipher.init(Cipher.DECRYPT_MODE, sharedSecret.getSecretKey(), sharedSecret.getIv());
            decrypted = new String(syncCipher.doFinal(Base64.getDecoder().decode(encrypted)), StandardCharsets.UTF_8);
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException ex) {
            ex.printStackTrace();
        }
        System.out.println("Decrypted sync: " + decrypted);
        return decrypted;
    }

    public static String decryptWithDigitalEnvelope(String encrypted) {
        System.out.println("Encrypted pgp: " + encrypted);
        JsonObject json = Json.createReader(new StringReader(encrypted)).readObject();
        byte[] secret = Base64.getDecoder().decode(asyncDecrypt(json.getString("key")));
        byte[] tmp = new byte[SYNCH_KEY_SIZE / 8];
        System.arraycopy(secret, 0, tmp, 0, tmp.length);
        SecretKey secretKey = new SecretKeySpec(tmp, SYNC_ALGORITHM);
        System.arraycopy(secret, tmp.length, tmp, 0, tmp.length);
        IvParameterSpec iv = new IvParameterSpec(tmp);
        SharedSecret sharedSecret = new SharedSecret(SYNC_ALGORITHM, SYNCH_KEY_SIZE, iv, secretKey);
        String decrypted = syncDecrypt(sharedSecret, json.getString("value"));
        System.out.println("Decrypted pgp by " + privateKey + ": " + decrypted);
        return decrypted;
    }

    public static boolean verifyMAC(SharedSecret sharedSecret, String verifyString, String macString) {
        boolean result = false;
        try {
            mac.init(new SecretKeySpec(sharedSecret.getSecretKey().getEncoded(), MAC_ALGORITHM));
            result = macString.equals(Base64.getEncoder().encodeToString(mac.doFinal(verifyString.getBytes(StandardCharsets.UTF_8))));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String createMAC(SharedSecret sharedSecret, String str) {
        String result = null;
        try {
            mac.init(new SecretKeySpec(sharedSecret.getSecretKey().getEncoded(), MAC_ALGORITHM));
            result = Base64.getEncoder().encodeToString(mac.doFinal(str.getBytes(StandardCharsets.UTF_8)));
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String getHash(String str) {
        String result = null;
        try {
            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
            md.update(str.getBytes(StandardCharsets.UTF_8));
            result = Base64.getEncoder().encodeToString(md.digest());
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
