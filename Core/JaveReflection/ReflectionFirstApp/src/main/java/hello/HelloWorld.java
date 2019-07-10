package hello;

import org.joda.time.LocalTime;

import java.lang.reflect.InvocationTargetException;

public class HelloWorld {
    public static void main(String[] args) {

        try {
            ReflectionHelper.getFields();
            //ReflectionHelper.modifyPrivateFields();
            ReflectionHelper.createDinamically2();
            ReflectionHelper.callDinamically3();
            ReflectionHelper.callDinamically5();
        } catch (NoSuchFieldException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
       }
}
