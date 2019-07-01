package example.jsonrpc4j.springboot;

//import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
//import com.googlecode.jsonrpc4j.ProxyUtil;
//import example.jsonrpc4j.springboot.api.ExampleClientAPI;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class ApplicationConfig {
//    private static final String endpoint = "http://localhost:9000/calculator";
//
//
//    @Bean
//    public JsonRpcHttpClient jsonRpcHttpClient() {
//        URL url = null;
//        //You can add authentication headers etc to this map
//        Map<String, String> map = new HashMap<>();
//        try {
//            url = new URL(ApplicationConfig.endpoint);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return new JsonRpcHttpClient(url, map);
//    }
//
//
//    @Bean
//    public ExampleClientAPI exampleClientAPI(JsonRpcHttpClient jsonRpcHttpClient) {
//        return ProxyUtil.createClientProxy(getClass().getClassLoader(), ExampleClientAPI.class, jsonRpcHttpClient);
//    }
//}


import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    public static AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
        //in here you can provide custom HTTP status code providers etc. eg:
        //exp.setHttpStatusCodeProvider();
        //exp.setErrorResolver();
        return exp;
    }
}