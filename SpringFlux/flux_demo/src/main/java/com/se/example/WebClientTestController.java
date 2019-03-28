package com.se.example;


import com.google.common.net.HttpHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.Date;

@RestController
@RequestMapping("/webclient")
public class WebClientTestController {


    private WebClient webclient = WebClient.builder()
            .baseUrl("http://localhost:8800")
            .build();

    private static final Logger LOGGER = LoggerFactory.getLogger(WebClientTestController.class);

    @GetMapping("/test")
    public String test() {

        return "https://www.baeldung.com/spring-5-webclient";
    }

    private Flux<String> getresult() {
        return webclient.get()
                .uri("/api/user")
              //  .body(BodyInserters.fromObject())
                .retrieve()
                .onStatus(HttpStatus::is2xxSuccessful,clientResponse -> {

                    //TODO: not implemented
                  return null;
                })
                .bodyToFlux(String.class);
    }


    //11
    private static Throwable handleAuthTokenError(Throwable e) {
        LOGGER.error("Exception caught trying to process authentication token. ", e);
        //  ContentCheckerApplication.handleAuthTokenResponse("");
        return null;
    }

    private static void handleAuthTokenResponse(String newToken) {

        LOGGER.info("Got status code!");

        if (!newToken.isEmpty()) {

            LOGGER.info("Auth token is: " + newToken);

        } else {
            LOGGER.info("Unable to authenticate successfully!");
        }

        System.exit(0);
    }

    private WebClient buildWebClient(String url) {
        return WebClient
                .builder()
                .baseUrl("http://localhost:8080")
                .build();
    }

//    private ExchangeFilterFunction logRequest(){
//        return (clientRequest,next) ->{
//            logget
//        }
//    }

}
