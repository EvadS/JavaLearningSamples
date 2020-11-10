package som.se.company.app;

import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "IOU FLOW to Json ");

        System.getenv().forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });

        System.out.println("--------------------------------------------------------");
        System.out.println("my var :  " + System.getenv().get("DB_HOST")  );


        // gets the value of the specified environment variable "PATH"
        System.out.println("System.getenv("+"PATH"+") = ");

        String myVar  = System.getenv("MY_VAR");
        System.out.println("myVar : "+ myVar);
        System.out.println("================================");
        String myVar2  = System.getenv("MY_VAR2");
        System.out.println("myVar2 : "+ myVar2);

        System.out.println("---------------------------------------");
        String sysEnvStr = System.getenv("SOAPBOX_ENV");
        System.out.println("SOAPBOX_ENV: " + sysEnvStr);
        System.out.println("---------------------------------------");


        System.out.println("---------------------------------------");
         sysEnvStr = System.getenv("MY_PROFILE");
        System.out.println("MY_PROFILE: " + sysEnvStr);
        System.out.println("---------------------------------------");





//
//        Car car = new Car("model1 ", 1.0, 20.0, "reference number");
//
//        String a = "O=PartyA,L=London,C=GB";
//        String b = "O=PartyB,L=New York,C=US";
//
//
//        CarState  carState = new CarState(car,a,  b);
//        IOUFlow flow = new IOUFlow(carState, b);
//
//        String json = GJSONSemple.ConvertFlowToJson(flow);

        System.out.println("---------------");
        //System.out.println(json);
    }

    public static void getEnv() {

        // Get the value of
        // all environment variables at once
        // and store it in Map
        Map<String, String> env
                = System.getenv();

        for (String envName : env.keySet()) {
            System.out.format("%s=%s%n",envName,env.get(envName));
        }
    }
}
