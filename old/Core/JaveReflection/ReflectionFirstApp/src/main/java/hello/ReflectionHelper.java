package hello;

import sun.rmi.rmic.iiop.ImplementationType;
import sun.rmi.rmic.iiop.InterfaceType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReflectionHelper {

    public  static void getFields() throws NoSuchFieldException {
       // String [] array = {"1","2","3"};
       // new ArrayList<>(Arrays.asList(array));
        Person personObj = new Person("Person name ");

        Class c = personObj.getClass();
        Field[] publicFields = c.getFields();
        for (Field field : publicFields) {
            Class fieldType = field.getType();
            System.out.println("Имя: " + field.getName());
            System.out.println("Тип: " + fieldType.getName());
        }
        //  Если известно имя поля, то можно получить о нем информацию с помощью метода getField()
       // Field nameField = c.getField("name");

        Method[] methods = personObj.getClass().getMethods();

        try
        {
            for(int i=0;i<methods.length;i++)
            {
                String name=methods[i].getName();
                if(name=="print")
                {
                    methods[i].invoke(personObj,"Test Parameters of A");
                }
                else if (name == "setName")
                {
                    methods[i].invoke(personObj,"NEW NAME!!!");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    public  static void getConstructorParams ()
    {
        Person obj = new Person("Person name ");

        Class c = obj.getClass();
        Constructor[] constructors = c.getConstructors();
        for (Constructor constructor : constructors) {
            Class[] paramTypes = constructor.getParameterTypes();
            for (Class paramType : paramTypes) {
                System.out.print(paramType.getName() + " ");
            }
            System.out.println();
        }
    }

    /**
     * Загрузка и динамическое создание экземпляра класса
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public  static void createDinamically () throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       // когда имя класса неизвестно до момента выполнения
        Class c = Class.forName("hello.Person");
        Object obj = c.newInstance();
        Person test = (Person) obj;
    }

    public  static void callDinamically4 () throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class c = Class.forName("hello.Person");
        Object obj = c.newInstance();

        Method meth2= c.getMethod(  "test" );
        meth2.invoke(obj);
    }

    public  static void callDinamically3 () throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String name ;
        Class c = Class.forName("hello.Person");
        Object obj = c.newInstance();

        Method meth2= c.getMethod(  "getName" );
        Object value = meth2.invoke(obj);

        name = (String)value;

        System.out.println(String.format(" current name : %s",name));

    }

    public static void createDinamically2() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c = Class.forName("hello.Person");
        Object obj = c.newInstance();
        Class clss = c.getClass();
        Method[] methods = clss.getClass().getMethods();

        Method meth = c.getMethod(  "setName", String.class);
        meth.invoke(obj,"Simpe name");

        Method meth2= c.getMethod(  "print", String.class);
        meth2.invoke(obj,"SOME  ---  PARAMETERS");
      //  Class<?> aClass = Class.forName(FULLY_QUALIFIED_CLASS_NAME);
      //  Method method = aClass.getMethod(methodName, YOUR_PARAM_1.class, YOUR_PARAM_2.class);
      //  method.invoke(OBJECT_TO_RUN_METHOD_ON, YOUR_PARAM_1, YOUR_PARAM_2);

    }

    public static void modifyPrivateFields() throws NoSuchFieldException, IllegalAccessException {
        WithPrivateFinalField pf = new WithPrivateFinalField();

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf, 47);
        System.out.println(pf);

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        f.set(pf, "MODIFY S");
        System.out.println(pf);


        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf, "MODIFY S2");
        System.out.println(pf);
    }

    public static void callDinamically5() {

        try {
            String className = "hello.IRobot";// really passed in from config
            Class c = Class.forName(className);
            InterfaceType interfaceType = (InterfaceType)c.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
