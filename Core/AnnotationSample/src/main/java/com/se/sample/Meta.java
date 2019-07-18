package com.se.sample;

import java.lang.reflect.Method;

public class Meta {
    // аннотировать ме тод
    @MyAnno(str = " Пример аннотации ", val = 1000)
    public static void myMeth() {
        Meta ob = new Meta();

        // получить аннотацию и з ме тода
        // и вывести значения е е членов
        try {
            // сначала получить объект типа Class ,
            // представляющий данный класс
            Class<?> c = ob.getClass();
            // затем получить объект типа Мethod,
            //  представляющий данный метод
            Method m = c.getMethod("myMeth ");
            //далее получит ь аннотацию дл я данного класса
            MyAnno anno = m.getAnnotation(MyAnno.class);
            // и на конец , вывести значения членов аннотации
            System.out.println(anno.str() + " " + anno.val());
        } catch (NoSuchMethodException ехс) {
            System.out.println("Meтoд не найден . ");
        }
    }

    public static void main(String[] args) {
        myMeth();
    }
}