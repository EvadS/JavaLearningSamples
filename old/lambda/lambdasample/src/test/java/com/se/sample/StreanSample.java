package com.se.sample;

import com.se.sample.interfaces.Artist_1;
import com.se.sample.interfaces.Artist_2;
import com.se.sample.interfaces.Artist_3;
import com.se.sample.model.Artist;
import org.junit.Test;

import java.util.Optional;
import java.util.function.IntFunction;
import java.util.logging.Logger;
import java.util.stream.Stream;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StreanSample {

    Logger log = Logger.getLogger(StreanSample.class.getName());

    @Test
    public void sample1() {


        Stream stream = Stream.of(1, 2, 3, 4, 5, 6);

        Optional<String> a = Optional.of("a");
        assertEquals("a", a.get());

        Optional emptyOptional = Optional.empty();
        Optional alsoEmpty = Optional.ofNullable(null);

        assertFalse(emptyOptional.isPresent());
        // а определено выше
        assertTrue(a.isPresent());

        assertEquals("b", emptyOptional.orElse("b"));
        assertEquals ("с", emptyOptional. orElseGet ( () -> "с"));
    }

    @Test
    public void sample_static(){
        Artist_1 newArtist =  (name, nationality) -> new Artist(name,nationality);
        Artist_1 newArtist2 =  Artist::new;


        Artist_2 art2 = Artist::new;
     //   Artist aaa = art2.cbuildArtist(1,"2","4");

        Artist_3 artist_3 = Artist::new;


        newArtist.cbuildArtist("name", "2222222222");
        String str = newArtist.toString();

        IntFunction<int[]> factory = int[]::new;
       factory.apply(2);
       factory.apply(3);

    }


    class MyClass {
        private int id;
        private String name;

        public MyClass(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }


}

