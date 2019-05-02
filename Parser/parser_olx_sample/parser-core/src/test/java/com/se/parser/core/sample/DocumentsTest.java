package com.se.parser.core.sample;

import com.se.parser.core.sample.parser.DocumentHelper;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class DocumentsTest {
    Document document;
    @Before
    public void init() throws IOException {
        document = DocumentHelper.createDocumentFromFile("detskiy-mir.html");
    }

    //how to write
    @Test
    public void downloadPage() throws Exception {
        final Connection.Response response = Jsoup.connect("https://www.olx.ua/detskiy-mir").execute();
        final Document doc = response.parse();

        final File f = new File("files/detskiy-mir.html");
        FileUtils.writeStringToFile(f, doc.outerHtml(), "UTF-8");

        Assert.assertNotNull(f);
    }

    @Test
    public void shold_parse_one(){

    }


}
