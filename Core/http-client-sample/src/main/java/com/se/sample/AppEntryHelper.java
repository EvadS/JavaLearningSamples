package com.se.sample;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class AppEntryHelper {
    private static final String TEST_URL = "http://httpclient.requestcatcher.com/test";
    public static String RawResponseTest() throws IOException {
    /*

    HttpRequestFactory this is used to build our requests
HttpTransport an abstraction of the low-level HTTP transport layer
GenericUrl a class that wraps the Url
HttpRequest handles the actual execution of the request
     */
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl("https://github.com"));
        String rawResponse = request.execute().parseAsString();

        return rawResponse;
    }


    private static String postRequestFormUrlencoded() throws IOException {
        GenericUrl url = new GenericUrl(TEST_URL);
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("arg1", true);
        data.put("arg2", 45);
        HttpContent content = new UrlEncodedContent(data);
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();

        HttpResponse response =   requestFactory.buildPostRequest(url, content).execute();

        String rawResponse = response.parseAsString();

        return rawResponse;
    }
}
