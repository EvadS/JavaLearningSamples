package fully.qualified;

import fully.qualified.Model.AbstractPerson;
import fully.qualified.Model.Person;
import fully.qualified.Model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


public class MainClass {


    private static List<Object> objects;

    public static void main(String[] args) {

        //----
        // Setup
        objects =  new ArrayList();

        objects.add(new Integer(15));
        objects.add(new Double(12));
        objects.add("hello");
        objects.add(new ArrayList());
        objects.add( new HashMap(3));
        objects.add("world");

        ///
        List<AbstractPerson> list = new ArrayList<AbstractPerson>();

        AbstractPerson p1 = new Student("ivanov", "Ivan", "123456");
        AbstractPerson p2 = new Student("Smirnoff", "Ivan", "123456");

        AbstractPerson p3 = new Person("Sidoroff", "Ivan", "male");
        AbstractPerson p4 = new Person("zadov", "Ivan", "female");

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);


        filter_elements_by_type_java8_lambda();

        System.out.print("-------------------");

        filter_elements_by_type_java8_lambda_my(list);

        System.out.println("......");
    }

    public void filter_elements_by_type_java(List<AbstractPerson> list) {

        List<String> strings = new ArrayList<String>();

        for (Object obj : list) {

            if (obj instanceof String) {
                strings.add((String) obj);
            }
        }
    }

    private static  void filter_elements_by_type_java8_lambda() {

        List<String> strings = objects
                .stream()
                .filter(p -> p instanceof String)
                .map(p -> (String) p)
                .collect(Collectors.toList());

        System.out.println(strings);

        System.out.println("strings");

    }

    private static  void filter_elements_by_type_java8_lambda_my( List<AbstractPerson> objects ) {

        List<Student> strings = objects
                .stream()
                .filter(p -> p instanceof Student)
                .map(p -> (Student) p)
                .collect(Collectors.toList());

        System.out.println(strings);

        System.out.println("strings");

    }
}
