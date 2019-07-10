package com.se.sample;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

        Currency usCoin = Currency.DIME;

        switch (usCoin) {
            case PENNY:
                System.out.println("Penny coin");
                break;
            case NICKLE:
                System.out.println("Nickle coin");
                break;
            case DIME:
                System.out.println("Dime coin");
                break;
            case QUARTER:
                System.out.println("Quarter coin");
        }

        for(Currency coin: Currency.values()){
            System.out.println("coin: " + coin);
        }

        System.out.println("---------------------------------------");

        for(Color color: Color.values()){
            color.printValue();
        }


        int i = 15;
        String hex = Integer.toHexString(i);
        System.out.println("Hex value  is " + hex);

        String string = "32";
        int no = Integer.parseInt(string);
        String hex2 = Integer.toHexString(no);
        System.out.println("Hex value is " + hex2);

        int noBytes = 0x400;
        System.out.println(String.format("Hex value of 0x400 is  %s" ,  noBytes));

     System.out.println("Hello World!");
    }

    public static String byteToHex(byte num) {
        char[] hexDigits = new char[2];
        hexDigits[0] = Character.forDigit((num >> 4) & 0xF, 16);
        hexDigits[1] = Character.forDigit((num & 0xF), 16);
        return new String(hexDigits);
    }
}
