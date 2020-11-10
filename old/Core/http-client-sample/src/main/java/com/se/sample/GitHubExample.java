package com.se.sample;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;
import com.google.gson.reflect.TypeToken;
import com.se.sample.model.GitHubUrl;
import com.se.sample.model.User;

import java.lang.reflect.Type;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.List;

public class GitHubExample {
    //based on the HttpURLConnection that is found in all Java SDKs. T
    static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

    //is the fastest and most popular library for parsing/serialization operations.
    static JsonFactory JSON_FACTORY = new JacksonFactory();

    public static void run() throws Exception {
        HttpRequestFactory requestFactory
                = HTTP_TRANSPORT.createRequestFactory(
                (HttpRequest request) -> {
                    request.setParser(new JsonObjectParser(JSON_FACTORY));
                });

        GitHubUrl url = new GitHubUrl("https://api.github.com/users");
        url.per_page = 10;


        // GET !!!
        HttpRequest request = requestFactory.buildGetRequest(url);

        HttpHeaders headers = request.getHeaders();
        headers.setUserAgent("Baeldung Client");
        headers.set("Time-Zone", "Europe/Amsterdam");


        // это возможность повторять запросы на основе определенных кодов состояния и пороговых значений.
        ExponentialBackOff backoff = new ExponentialBackOff.Builder()
                .setInitialIntervalMillis(500)
                .setMaxElapsedTimeMillis(900000)
                .setMaxIntervalMillis(6000)
                .setMultiplier(1.5)
                .setRandomizationFactor(0.5)
                .build();

        request.setUnsuccessfulResponseHandler(new HttpBackOffUnsuccessfulResponseHandler(backoff));

        Type type = new TypeToken<List<User>>() {
        }.getType();

        List<User> users = (List<User>) request
                .execute()
                .parseAs(type);
        System.out.println(users);
        System.out.println("----------------------");
        url.appendRawPath("/eugenp");
        request = requestFactory.buildGetRequest(url);
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<HttpResponse> responseFuture = request.executeAsync(executor);
        User eugen = responseFuture.get().parseAs(User.class);
        System.out.println(eugen);
        executor.shutdown();




    }
}
