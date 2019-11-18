package com.se.sample.inplementation;

import com.se.sample.helper.MExpressionHelper;
import com.se.sample.interfaces.Expression;
import com.se.sample.interfaces.Operationable;

public class LambdaApp {

    private static int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void implOperationable_ver1() {
        Operationable op = new Operationable() {

            @Override
            public int calculate(int x, int y) {
                return 0;
            }
        };
    }


    public static void implOperationable_ver2(int x, int y) {
        Operationable operationable;
        operationable = (x1, y1) -> x1 + y1;

        int result = operationable.calculate(x, y);
        System.out.println(result);

    }

    public static void printableTest(int x, int y) {
        String a;
        Operationable operationable = new Operationable() {

            @Override
            public int calculate(int x1, int y1) {
                return x1 + y1;
            }
        };

        int z = operationable.calculate(x, y);
        System.out.println(z);
    }

    /**
     * для одного функционального интерфейса мы можем определить множество лямбда-выражений.
     *
     * @param _x
     * @param _y
     */
    public static void calculateByLambda(int _x, int _y) {
        Operationable operation1 = (int x, int y) -> x + y;
        Operationable operation2 = (int x, int y) -> x - y;
        Operationable operation3 = (int x, int y) -> x * y;

        System.out.println(operation1.calculate(_x, _y)); //30
        System.out.println(operation2.calculate(_x, _y)); //10
        System.out.println(operation3.calculate(_x, _y)); //200
    }

    /**
     * использование блоков кода
     *
     * @param _x
     * @param _y
     */
    public static void calculateByLambda2(int _x, int _y) {
        Operationable operation = (int x, int y) -> {

            if (y == 0)
                return 0;
            else
                return x / y;
        };

        System.out.println(operation.calculate(20, 10)); //2
        System.out.println(operation.calculate(20, 0)); //0
    }

    /**
     * преимуществ лямбд в java является то, что их можно передавать в качестве параметров в методы.
     */
    public static void calculateExpressions() {
        //в данном случае все числа должны быть четными или остаток от их деления на 2 должен быть равен 0.
        Expression func = (n) -> n % 2 == 0;

        System.out.println(sum(nums, func)); // 20
    }

    /**
     * вычисляет сумму всех элементов массива, соответствующих некоторому условию.
     *
     * @param numbers
     * @param func
     * @return
     */
    private static int sum(int[] numbers, Expression func) {
        //
        // на момент написания метода sum мы можем абсолютно не знать, какое именно условие будет использоваться
        int result = 0;
        for (int i : numbers) {
            if (func.isEqual(i))
                result += i;
        }
        return result;
    }

    public static void calculateExpressions2() {
        Expression func = (n) -> n % 2 == 0;

        /*
        На место второго параметра передается ExpressionHelper::isEven, то есть
         ссылка на статический метод isEven() класса ExpressionHelper. При этом методы, на которые идет ссылка,
         должны совпадать по параметрам и результату с методом функционального интерфейса
         */
        System.out.println(sum(nums, MExpressionHelper::isEven));

        Expression expr = MExpressionHelper::isPositive;
        System.out.println(sum(nums, expr));

        System.out.println(sum(nums, func)); // 20
    }
}
