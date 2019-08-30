package my.pack;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/// заглушка
public class SharedSecret {
    public SharedSecret(byte[] digest, String syncAlgorithm, int synchKeySize) {
    }

    public SharedSecret(String syncAlgorithm, int synchKeySize, IvParameterSpec iv, SecretKey secretKey) {
    }

    public Key getSecretKey() {
        return null;
    }

    public SecureRandom getIv() {
        return  null;
    }
}
