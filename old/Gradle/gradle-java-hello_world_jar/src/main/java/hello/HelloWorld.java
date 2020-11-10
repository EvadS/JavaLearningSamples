package hello;


import org.apache.log4j.Logger;
import org.joda.time.LocalTime;



public class HelloWorld {
      private static final Logger LOG = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is: " + currentTime);

        Greeter greeter = new Greeter();
        System.out.println(greeter.sayHello());

        LOG.info("Application started");
        System.out.println("I'm the main project");
        LOG.info("Application finished");*/
    }
}
