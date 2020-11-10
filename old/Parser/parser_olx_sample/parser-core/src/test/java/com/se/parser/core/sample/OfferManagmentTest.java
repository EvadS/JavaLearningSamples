package com.se.parser.core.sample;

import com.se.parser.core.sample.dataBase.OfferManagment;
import com.se.parser.core.sample.model.Offer;
import org.junit.Test;

import java.sql.SQLException;

public class OfferManagmentTest {

    @Test
    public void sould_some_return () throws SQLException {

        Offer offer = new Offer(1, "String name", "String category", "String location",
                "String date", "String offerImage",
                "String linkUrl", "String price", false);

   OfferManagment.insertIfExists(offer);
//      System.out.println("result : " + result);
//
//         result =  OfferManagment.insertIfExists(offer);
//        System.out.println("result : " + result);
    }
}
