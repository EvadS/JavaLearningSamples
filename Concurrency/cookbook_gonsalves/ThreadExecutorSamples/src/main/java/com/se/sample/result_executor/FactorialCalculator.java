package com.se.sample.result_executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class FactorialCalculator implements Callable<Integer> {

    private final Integer number;

    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    /**
     * factorial of the number
     *
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {

        int result = 1;

        if ((number == 0) || (number == 1)) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                TimeUnit.MILLISECONDS.sleep(20);
            }
        }

        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);

        return result;
    }
}
