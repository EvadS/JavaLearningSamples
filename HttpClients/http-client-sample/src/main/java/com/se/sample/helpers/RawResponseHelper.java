package com.se.sample.helpers;

import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * com.google.api.client demo
 */
public class RawResponseHelper {
    private static final String TEST_URL = "http://httpclient.requestcatcher.com/test";
    public static final String HTTPS_GITHUB_COM = "https://github.com";

    public static String RawResponseTest() throws IOException {
    /*

    HttpRequestFactory this is used to build our requests
HttpTransport an abstraction of the low-level HTTP transport layer
GenericUrl a class that wraps the Url
HttpRequest handles the actual execution of the request
     */
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(HTTPS_GITHUB_COM));
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

        HttpResponse response = requestFactory.buildPostRequest(url, content).execute();

        String rawResponse = response.parseAsString();

        return rawResponse;
    }
}
