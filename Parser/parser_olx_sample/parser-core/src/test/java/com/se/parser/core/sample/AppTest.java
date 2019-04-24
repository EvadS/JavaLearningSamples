package com.se.parser.core.sample;

import static org.junit.Assert.assertTrue;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException {
        File input = new File("files/base_page.txt");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        assertTrue( true );
    }

    //how to write
    public void downloadPage() throws Exception {
//        final Connection.Response response = Jsoup.connect("http://www.example.net").execute();
//        final Document doc = response.parse();
//
//        final File f = new File("files/filename.html");
//        FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");
    }

    @Test
    public void testSelect(){
        String html = "<a class=\"sushi-restaurant\" href=\"/greatSushi\">Best Sushi in town</a>";
        Document doc = Jsoup.parse(html, "http://example.com/");
        // find all <a class="sushi-restaurant">...
        Elements links = doc.select("a.sushi-restaurant");
        Element link = links.first();
        // 'abs:' makes "/greatsushi" = "http://example.com/greatsushi":
        String url = link.attr("abs:href");
        System.out.println("url = " + url);
    }

    @Test
    public void testSelect_base(){
        String html = "<div class=\"test\"> <a class=\"sushi-restaurant\" href=\"/greatSushi\">Best Sushi in town</a><a class=\"m-sushi\" href=\"/greatSushi\">Best Sushi in town</a></div>";
        Document doc = Jsoup.parse(html, "http://example.com/");
        // find all <a class="sushi-restaurant">...
        Elements div = doc.select("div.test > a.sushi-restaurant2");

        System.out.println("div : " + div);
    }
}
