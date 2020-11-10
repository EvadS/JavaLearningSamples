package lambdaJavaExample;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    List<Object> objects;

    @Before
    public void setUp () {
        objects = new ArrayList();

        objects.add(new Integer(15));
        objects.add(new Double(12));
        objects.add("hello");
        objects.add( new ArrayList());
        objects.add(new HashMap<>());
        objects.add("world");
    }

    @Test
    public void filter_elements_by_type_java () {

        List<String> strings = new ArrayList<String>();

        for (Object obj : objects) {

            if (obj instanceof String) {
                strings.add((String) obj);
            }
        }

        assertTrue(strings.contains("hello"));
        assertTrue(strings.contains("world"));
    }

    @Test
    public void filter_elements_by_type_java8_lambda () {

        List<String> strings = objects
                .stream()
                .filter(p -> p instanceof String)
                .map(p -> (String) p)
                .collect(Collectors.toList());

        System.out.println(strings);

        assertTrue(strings.contains("hello"));
        assertTrue(strings.contains("world"));
    }
}
