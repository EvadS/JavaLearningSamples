package com.se.parser.core.sample.helper;

import com.se.parser.core.sample.model.Category;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;


public class TopCategoriesHelper {

    public static final String TopLinkClass = "maincategories-list";

    public static String getTopCategoriesFromString(String html, String topCategoriesClass) {

        //   Elements elements =
        return new String();
    }


    public static Elements getTopCategoriesFromString(Document document, String topCategoriesClass) {
        Elements elements = document.select("div.maincategories > div.maincategories-list > div.li.fleft > div.item > a");
        return elements;
    }

    public static List<Category> getTopCategoriesListFromString(Document document) {
        List<Category> categoriesList = new ArrayList<>();
        Elements elements = document.select("div.maincategories > div.maincategories-list > div.li.fleft > div.item > a");

        for (Element element : elements) {
            String url = element.attr("href");
            String title = element.text();
            String dataId = element.attr("data-id");
            int id = Integer.parseInt(dataId);

            Category category = new Category();
            category.setLink(url);
            category.setTitle(title);
            category.setId(id);

            categoriesList.add(category);
        }

        return categoriesList;
    }
}
