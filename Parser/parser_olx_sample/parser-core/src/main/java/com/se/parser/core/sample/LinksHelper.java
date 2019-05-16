package com.se.parser.core.sample;

import com.se.parser.core.sample.settings.BaseSettings;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinksHelper {

    public static void getAllLinks() throws IOException {
        Connection.Response  res  = Jsoup.connect(BaseSettings.BASE_URL)
                .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/49.0.2623.87 Safari/537.36")
                .execute();

        Document doc = res.parse();

        System.out.println(doc.body());
        // Elements extends ArrayList<Element>.
        Elements aElements = doc.getElementsByTag("a");
        Elements aElements2 = doc.getElementsByClass("maincategories-list");

        for (Element aElement : aElements) {
            String href = aElement.attr("href");
            String text = aElement.text();
            System.out.println(text);
            System.out.println("\t" + href);
        }

        int a =10;
    }

    public static List<String> getCategories(){
        List<String> result = new ArrayList<>();

        return  result;
    }
}
