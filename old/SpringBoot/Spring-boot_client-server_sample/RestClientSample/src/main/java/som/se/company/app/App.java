package som.se.company.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("---------------");
        SimplePostRequestTest request = new SimplePostRequestTest();

        try {
                        MyGson mson = new MyGson();
          //   mson.http("http://localhost:8086/test-post"," \"name\": \"MAZ\"");
           //  request.multipartFileUpload();

            request.multipartFileUpload2();

        //     request.runMultiFile();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }


}
