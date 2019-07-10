package com.se.parser.core.sample;

import com.se.parser.core.sample.model.Offer;
import com.se.parser.core.sample.parser.OffersHelper;
import com.se.parser.core.sample.parser.DocumentHelper;
import com.se.parser.core.sample.parser.utils.BaseSearch;
import com.se.parser.core.sample.parser.utils.GeoSearch;
import com.se.parser.core.sample.settings.BaseSettings;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class OfferTest {

    Document document;
    @Before
    public void init() throws IOException {
        document = DocumentHelper.createDocumentFromFile("detskiy-mir.html");
    }

    @Test
    public void should_get_categories_links(){

        List<Offer> elements =  OffersHelper.getAnnouncementsList(document);

        Assert.assertNotNull(elements);
    }

    @Test
    public void should_get_subcategories(){

        int rrr = OffersHelper.offerCount(document);
         OffersHelper.getSubcategories(document);
    }

    @Test
    public  void should_parse() throws IOException, SQLException {
        BaseSearch baseSearch = new BaseSearch(1);
        GeoSearch geoSearch = new GeoSearch("иж-49");


        OffersHelper.parseAll(BaseSettings.ZAPCHASTI_DLYA_TRANSPORTA, baseSearch,geoSearch);
    }
}
