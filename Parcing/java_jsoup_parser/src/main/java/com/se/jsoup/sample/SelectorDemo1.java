package com.se.jsoup.sample;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SelectorDemo1 {

    public static void main(String[] args) throws IOException {
        File htmlFile = new File("document.html");
        Document doc = Jsoup.parse(htmlFile, "UTF-8");

        // First <div> element has class ="related-container"
        Element div = doc.select("div.related-container").first();

        // List the <h3>, the direct child elements of the current element.
        Elements h3Elements = div.select("> h3");

        // Get first <h3> element
        Element h3 = h3Elements.first();

        System.out.println(h3.text());

        // List <a> elements, is a descendant of the current element
        Elements aElements = div.select("a");


        // Query the current element list.
        // The element that href contains 'installing'.
        Elements aEclipses = aElements.select("[href*=Installing]");

        Iterator<Element> iterator = aEclipses.iterator();

        while (iterator.hasNext()) {
            Element a = iterator.next();
            System.out.println("Document: "+ a.text());
        }
    }

}