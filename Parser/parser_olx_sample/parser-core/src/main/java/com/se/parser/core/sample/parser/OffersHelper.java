package com.se.parser.core.sample.parser;

import com.se.parser.core.sample.dataBase.OfferManagment;
import com.se.parser.core.sample.model.Category;
import com.se.parser.core.sample.model.Offer;
import com.se.parser.core.sample.parser.utils.BaseSearch;
import com.se.parser.core.sample.parser.utils.GeoSearch;
import com.se.parser.core.sample.settings.BaseSettings;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OffersHelper {

    //TODO: added logger

    public static final String OFFER_PATTERN = "table.fixed.offers>tbody>tr.wrap>td";
    public static final String SUBCATEGORY_PATTERN = "#topLink>div.inner>ul>li";

    public static List<Category> getSubcategories(Document baseDocument) {
        List<Category> res = new ArrayList<>();
        Elements offersElements = baseDocument.select(SUBCATEGORY_PATTERN);

        for (Element item : offersElements) {
            String link = offersElements.first().select("a").attr("href");
            String dataid = offersElements.first().select("a").attr("data-id");
            String text = offersElements.first().select("a> span> span").text();

            int id = Integer.parseInt(dataid);
            Category subCategory = new Category(id, link, text);
        }

        return res;
    }

    public static int offerCount( Document document ) {
        int res = 0;

        Elements pagesElements = document.select("div.pager.rel.clr > span> a");

        for (Element item : pagesElements) {

            String dataCy = item.attr("data-cy");

            if (dataCy.equals("page-link-last")) {
              String pagecount  =  item.select("span").text();
              res = Integer.parseInt(pagecount);
            }
        }

        return res;

    }

    public static Document getDocumentByParams(String categoryLink , BaseSearch baseSearch, GeoSearch geoSearch) throws IOException {
        StringBuilder builder = new StringBuilder();

        builder.append(BaseSettings.BASE_URL);//
        builder.append("/");//
        builder.append(categoryLink);//

        if(geoSearch!=null){
            builder.append(geoSearch.toString());
        }

        if(baseSearch!=null){
            builder.append(baseSearch.toString());
        }
        // String.format("%s/%s", BaseSettings.BASE_URL,categoryLink);
        String url = builder.toString();

        final Connection.Response response = Jsoup.connect(url).execute();
        final Document doc = response.parse();

        return doc;
    }


    public static void parseAll(String categoryLink,BaseSearch baseSearch, GeoSearch geoSearch) throws IOException, SQLException {
        Document document =  getDocumentByParams(categoryLink,baseSearch,geoSearch);
        int pageNumber = OffersHelper.offerCount(document);

        List<Offer> offerList = getAnnouncementsList(document);
        OfferManagment.saveList(offerList);

        int onePercent = pageNumber/100;
        for (int i = 2 ; i <= pageNumber; i++){
            baseSearch.setPageNumder(i);
            document =  getDocumentByParams(categoryLink,baseSearch,geoSearch);

            offerList = getAnnouncementsList(document);
            OfferManagment.saveList(offerList);

            if(i%onePercent == 0){
                int currentProgress = i/onePercent ;
                System.out.println("...progress : " + currentProgress );
            }

            System.out.println("current page  : " + i );
        }
    }


    public static List<Offer> getAnnouncementsList(Document document) {
        List<Offer> res = new ArrayList<>();

        Elements offersElements = document.select(OFFER_PATTERN);

        for (Element element : offersElements) {

            try {
                boolean isPromoted = false;
                if (element.hasClass("promoted")) {
                    isPromoted = true;
                }

                String dataid = element.select("table").attr("data-id");
                Element body = element.select("table>tbody").first();


                String name = body.select("a.marginright5").text();
                String title = body.select("a.marginright5> strong ").first().text();

                String offerImage = body.select("a> img ").attr("src");

                String linkUrl = body.select("h3.margintop5>a").first().attr("href");

                String category = body.select("p.color-9.lheight16.margintop5> small").text();
                String price = body.select("p.price> strong").text();

                String location = body.select("td>div >p.lheight16 >small >span").first().text();
                String date = body.select("td>div >p.lheight16 >small >span").get(1).text();

                int id = Integer.parseInt(dataid);

                if(id == 570256529){
                    int aa =10;
                }

                Offer offer = new Offer(id, name, null,
                        location, date, offerImage, linkUrl, price, isPromoted);

                res.add(offer);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return res;
    }

    public static List<String> getSubcategory(Document document) {
        return null;
    }
}
