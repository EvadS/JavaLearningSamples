package com.se.sample;

/**
 * Hello world!
 *
 */
public class App 
{
    int a;


    void tets(){
        {
        // label for outer loop
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 1)
                    break outer;
                System.out.println(" value of j = " + j);
            }
        } // end of outer loop
    } // en

        System.out.println("Enter the marks (in 100):");
    }


    void test2()
    {
        int r = 5;
    }
    public static void main( String[] args )
    {
        App a = new App();

        System.out.println("a : "+ a.a);

    }
}
