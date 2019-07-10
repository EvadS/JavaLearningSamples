package com.se.jsoup.sample;

import java.io.IOException;

import com.sun.deploy.net.HttpResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetAllLinks {

    public static void main(String[] args) throws IOException {

//        Document doc = Jsoup.connect("https://o7planning.org/")
//                .header("cache-control", "no-cache")
//                .header("postman-token", "f032d7a0-a2c6-f66d-459a-faafed6933c4")
//                .get();

        Connection.Response  res  = Jsoup.connect("https://o7planning.org/")
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                .execute();


        Document  doc = res.parse();
        String sessionId = res.cookie("SESSIONID");
//2.Используем куки
//        Document doc2 = Jsoup.connect("urlYouNeedToBeLoggedInToAccess")
//                .cookie("SESSIONID", sessionId)
//                .get();

        Elements metaElements = doc.select("meta");
        for(Element metaElement: metaElements){
            System.out.println("\t" + metaElement);
        }

        System.out.println("-------------------------------------------" );
        // Elements extends ArrayList<Element>.
        Elements aElements = doc.getElementsByTag("a");

        for (Element aElement : aElements) {
            String href = aElement.attr("href");
            String text = aElement.text();
            System.out.println(text);
            System.out.println("\t" + href);
        }
    }

}