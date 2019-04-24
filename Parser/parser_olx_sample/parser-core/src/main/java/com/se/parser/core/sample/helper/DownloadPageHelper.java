package com.se.parser.core.sample.helper;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DownloadPageHelper {
    public static Document downloadPage(String address) throws IOException {
        Connection.Response res = Jsoup.connect(address)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                .execute();

        Document document = res.parse();

        return document;
    }

    public static Document downloadPageWithCoockie(String address, String cookieKey, String coockieValue) throws IOException {
        Connection.Response res = Jsoup.connect(address)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                .cookie(cookieKey, coockieValue)
                .execute();

        Document document = res.parse();

        return document;
    }
}