package som.se.company.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "IOU FLOW to Json ");


        Car car = new Car("model1 ", 1.0, 20.0, "reference number");

        String a = "O=PartyA,L=London,C=GB";
        String b = "O=PartyB,L=New York,C=US";


        CarState  carState = new CarState(car,a,  b);
        IOUFlow flow = new IOUFlow(carState, b);

        String json = GJSONSemple.ConvertFlowToJson(flow);

        System.out.println("---------------");
        System.out.println(json);
    }
}
