package som.se.sample;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.zip.CRC32;


import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.core.io.buffer.DefaultDataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


import java.util.List;


/**
 * Hello world!
 */
public class App {


    private static String NODE_INFO_URL = "/node-info";


    private WebClient webClient2;

    public static void main(String[] args) {


        try {
            first_test3();
            first_test3();
            first_test2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.print("------------------------");


        try {

            int aa = 10;
            WebClient webClient = WebClient.create("http://localhost:8898/");


            Mono<String> result = webClient.get()
                    .uri("/node-info")
                    .retrieve().bodyToMono(String.class);


            Flux result2 = webClient.get().uri("/node-info")
                    .retrieve()
                    .bodyToFlux(String.class);


            int aaa = 1;


            ////

            WebClient webClientB = WebClient.builder()
                    .baseUrl("https://api.github.com")
                    .defaultHeader(HttpHeaders.CONTENT_TYPE, "application/vnd.github.v3+json")
                    .defaultHeader(HttpHeaders.USER_AGENT, "Spring 5 WebClient")
                    .build();


        } catch (Exception ex) {
            System.out.print("------------------------");
            ex.printStackTrace();
            System.out.print("------------------------");
        }


        try {
            first_test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void first_test() throws InterruptedException {
        WebClient webClient = WebClient.create("http://localhost:8898/node-info");
        Mono<String> result = webClient.get()
                .retrieve()
                .bodyToMono(String.class);
        String response = result.block();
        System.out.println(response);
    }

    private static void first_test2() throws InterruptedException {

        int t = 0;
        WebClient webClient = WebClient.create("http://localhost:8898");
        Mono<String> result = webClient.get()
                .uri("/node-info")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(String.class);

        String response = result.block();
        System.out.println(response);
    }


    private static void first_test3() throws InterruptedException {

        WebClient webClient = WebClient.create("http://localhost:8898");


        NodeInfoContainer[] blocks = webClient.get()
                .uri("/node-info")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NodeInfoContainer[].class).block();



        List<NodeInfoContainer> list = Arrays.asList(blocks);


        Mono<List <NodeInfoContainer>> monoResult;

        Mono<NodeInfoContainer[]> mono = webClient.get()
                .uri("/node-info")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(List<NodeInfoContainer>[].class);


        monoResult = Arrays.asList(mono);



        webClient.get()
                .uri("/node-info")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(NodeInfoContainer[].class).block();


        System.out.println("-====----------------------->>>>");
        for (NodeInfoContainer cont : blocks) {
            System.out.println(cont.toString());
        }

        System.out.println("=========<<------------------------");

        int aaa = 10;

    }


}

