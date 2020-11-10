package com.se.parser.core.sample.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class DocumentHelper {

    public static final String DOCUMENT_BASE_DIR = "files";
    public static final String DOCUMENT_FILE_NAME = "base_page.html";

    public static Document createDocumentFromFile(String filename) throws IOException {
        File file = new File(DOCUMENT_BASE_DIR.concat("/").concat(filename));
        return createDocumentFromFile(file);
    }

    public static Document createDocumentFromFile(File file) throws IOException {
        Document doc = Jsoup.parse(file, StandardCharsets.UTF_8.name());
        return doc;
    }

    public static Document fromString(String htmlString) {
        Document doc = Jsoup.parse(htmlString);
        return doc;
    }

    public static Document fromBodyFragment(String htmlFragment) {
        Document doc = Jsoup.parse(htmlFragment);
        return doc;
    }
}
