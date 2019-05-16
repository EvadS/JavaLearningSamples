package com.se.parser.core.sample;

import com.se.parser.core.sample.parser.DocumentHelper;
import com.se.parser.core.sample.parser.TopCategoriesHelper;
import com.se.parser.core.sample.model.Category;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.util.List;

public class TopCategoriesHelperTest {

    Document document;
    @Before
    public void init() throws IOException {
        document = DocumentHelper.createDocumentFromFile("base_page.txt");
    }

    @Test
    public void should_create_from_file(){
        Assert.assertNotNull(document);
    }

    @Test
    public  void download_categories_page (){
       // OffersHelper
        List<Category> categoriesList =  TopCategoriesHelper.getTopCategoriesListFromString(document);
        int len = categoriesList.size();
        Assert.assertTrue(len > 0);
    }


}
