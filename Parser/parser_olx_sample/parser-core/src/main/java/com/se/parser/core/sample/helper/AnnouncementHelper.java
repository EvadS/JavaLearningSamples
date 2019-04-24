package com.se.parser.core.sample.helper;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class AnnouncementHelper {
    public static Elements getAnnouncementsList(Document document) {
        int aaa = 1;

        Elements link = document.select("#offers_table >tbody > tr.wrap");
        int df= 0;
        Elements elements = document.select("div.maincategories > div.maincategories-list > div.li.fleft > div.item > a");

        int bb =10;
        return elements;
    }
}
