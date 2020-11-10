package hello;

class WithPrivateFinalField {
    private int i = 1;
    private final String s = "String S";
    private String s2 = "String S2";

    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}