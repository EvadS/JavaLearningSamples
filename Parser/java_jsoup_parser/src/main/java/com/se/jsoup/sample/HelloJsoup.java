package com.se.jsoup.sample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class HelloJsoup {

    public static void main(String[] args) throws IOException {
//        File htmlFile = new File("C:/index.html");
//        Document doc = Jsoup.parse(htmlFile, "UTF-8");
        Document doc = Jsoup.connect("http://eclipse.org").get();
        String title = doc.title();
        System.out.println("Title : " + title);


//        Document doc = Jsoup.connect("http://example.com")
//                .data("query", "Java")
//                .userAgent("Mozilla")
//                .cookie("auth", "token")
//                .timeout(3000)
//                .post();
    }




    /**
     * Создать  Document из String
     */
    public static void fromString() {
        String htmlString = "<html><head><title>Simple Page</title></head>"
                + "<body>Hello</body></html>";
        Document doc = Jsoup.parse(htmlString);
        String title = doc.title();
        System.out.println("Title : " + title);
        System.out.println("Content:\n");
        System.out.println(doc.toString());
    }

    public static void ParsingBodyDocument() {
        String htmlFragment = "\"<h1>Hi you!</h1><p>What is this?</p>\"";
        Document doc = Jsoup.parseBodyFragment(htmlFragment);
        String fullHtml = doc.html();
        System.out.println(fullHtml);
    }
}