package com.symphony;


import org.junit.Test;

import javax.crypto.Cipher;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.cert.X509Certificate;
import java.util.UUID;

import static org.junit.Assert.*;


/**
 * Unit test for SecurityKeyUtils
 *
 * @author Dan Nathanson
 */
public class SecurityKeyUtilsTest {

    private static String PKCS8_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n"
            + "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCuDYS+ctgFfDeo9sa8n3v1STVq\n"
            + "TkZdEnFPAhdtEY93iZd45OFChdts2IyehidgTLNzs2tA1TKcLyMXcib0Gy6nfHiP\n"
            + "aXfWJSMq8s1mIhk/6TL03HfI1U1+rgyc5Jzs5ti/o1WmHlgYoQD6+/9Qnt0vZXsr\n"
            + "HyKRQ4ozM5YPwg/+gwIDAQAB\n"
            + "-----END PUBLIC KEY-----";

    private static String PKCS8_PRIVATE_KEY = "-----BEGIN PRIVATE KEY-----\n"
            + "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAK4NhL5y2AV8N6j2\n"
            + "xryfe/VJNWpORl0ScU8CF20Rj3eJl3jk4UKF22zYjJ6GJ2BMs3Oza0DVMpwvIxdy\n"
            + "JvQbLqd8eI9pd9YlIyryzWYiGT/pMvTcd8jVTX6uDJzknOzm2L+jVaYeWBihAPr7\n"
            + "/1Ce3S9leysfIpFDijMzlg/CD/6DAgMBAAECgYA8bLUI6RXV0aoBHqsgEL4YCbJh\n"
            + "lYsYBK8RnshDNTV5amsLrWoGjjH/N66Z2jkRVY93O3Kgr2NClZq5KQgc9tLa/9OZ\n"
            + "V/WSPJm3WQHwBPhZJrmRCTiKVv6bn4QaAsODGBxM8OXnJslh+Da27Ui3pwBKGg6R\n"
            + "milK4vdgER7iG2+TAQJBANqhFzOGVSleAF+LFL37cJwF5ljp//yiGD/vvM7iTMIl\n"
            + "VJq7snFwDs6WeuLeNFv4Xc36H3Jeg0k0m6YB/FNHL08CQQDLzdMsxi6vqfAJErBe\n"
            + "QuqtGbTUGUQrvenfLG4617llhI3PgB4E7yQWjIkN+LqCWrmIGqiPqKIu4Ioip013\n"
            + "OhCNAkBhsZwxfPRvEL8v8nEpV8MBJS3CS4YE+NXHNDR1afAMzSuaHQdm40DqlZmB\n"
            + "6PMSqdAY64zDyXH281gd/UMoX2XHAkEAiaAUWsf5/uXjEj1snDrT/tC9K/1j66Xz\n"
            + "qKF4ToQezk8U9Gqv2uUimZeNdcHhMOXTI/XcniZiXwWCQqR3y2uKgQJAGnzJvOoG\n"
            + "kkDxOFGSrx4UXtFUAMvw78WmomecHLqNgF5cBEDtveazTyXjtJ/j0YOp92xysdZ1\n"
            + "jerPACw2ezHIyA==\n"
            + "-----END PRIVATE KEY-----";

    private static String PKCS1_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n"
            + "MIGeMA0GCSqGSIb3DQEBAQUAA4GMADCBiAKBgHG+5jq3tn3fncOhRnBEuAYEgrrO\n"
            + "y86J3RTOlDRq6fLJgvTJ2JMPsO8EVBES1cZSAdovSwUAWk48cLWXbyfWaTuYOZ37\n"
            + "YeyUQXYV7KAb7I47gRbWj6VoLB8XrBAlBDy4TuivA4g3pvPbN7k4B2nFtCJFssAv\n"
            + "LLx0PcC+Zp3lTr97AgMBAAE=\n"
            + "-----END PUBLIC KEY-----";

    private static String PKCS1_PRIVATE_KEY = "-----BEGIN RSA PRIVATE KEY-----\n"
            + "MIICWgIBAAKBgHG+5jq3tn3fncOhRnBEuAYEgrrOy86J3RTOlDRq6fLJgvTJ2JMP\n"
            + "sO8EVBES1cZSAdovSwUAWk48cLWXbyfWaTuYOZ37YeyUQXYV7KAb7I47gRbWj6Vo\n"
            + "LB8XrBAlBDy4TuivA4g3pvPbN7k4B2nFtCJFssAvLLx0PcC+Zp3lTr97AgMBAAEC\n"
            + "gYAM0bDsySueAAetto1Ttcrvkq6REyFRA6SQ5b86MRpwrFk/8UehO1F7fodi7TZ+\n"
            + "hVuEFXRk+eczjgg9zvVODhIJ5+TzSnPUDh3z5IriXehZQ7kfg6NhpmlQSakFyAwL\n"
            + "YY9XrTI603+R712VWCOruM3tyZ0tVoyhJd4hfKa8QKXFsQJBANZJZNvf3/3TDVWz\n"
            + "WuFDijFfOon5YRGu7oPMsPDiL260JVbTTce3QC1nvwfhWBpmpexMC2ZI/fvKG0yk\n"
            + "4GZIaJ8CQQCH4zganeX6ZBSCbq9UxOlHiWHaYqXg9Si17sfFXXqwT+xuykHdK+Q9\n"
            + "dfmS5R7kkskaSUgH1We7yWr67x0cPg+lAkBl0mgnhmCj9rZeY6QqZ/JxdWOWjjYO\n"
            + "tgXGAOyO+Zs6SkV31V4fKTdInASM1QoNOXtcJeJAzyxIiYehSrMKRxvXAkBmdRYq\n"
            + "S3/JqYglSFt+qPHTdGyJgvPbiD3n32BVGcSWB80XQ/0hTCTNipRhA8ylP1/OKA7d\n"
            + "iTSrzJSTG5NxZgHZAkAwt30fj+1OdNuasZZaqTAL3bGLI7Z5uRmvfOkvZxc13q47\n"
            + "TFttC2TKNDNuzFPFq04dEtdP49C8H46z4Z6J8wiY\n"
            + "-----END RSA PRIVATE KEY-----";


}