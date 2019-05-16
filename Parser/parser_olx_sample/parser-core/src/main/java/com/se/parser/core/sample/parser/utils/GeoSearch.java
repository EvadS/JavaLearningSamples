package com.se.parser.core.sample.parser.utils;

import com.mysql.cj.util.StringUtils;

//  /zapchasti-dlya-transporta/zap/q-test/
public class GeoSearch {
    private String obl;
    private String search;

    public GeoSearch( String search) {
        this.search = search;
    }

    public GeoSearch(String obl, String search) {
        this.obl = obl;
        this.search = search;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (!StringUtils.isNullOrEmpty(obl) && !StringUtils.isEmptyOrWhitespaceOnly(obl)) {
            builder.append("/" + obl);
        }

        if (!StringUtils.isNullOrEmpty(search) && !StringUtils.isEmptyOrWhitespaceOnly(search)) {
            builder.append("/q-" + search);
        }
        return builder.toString();
    }


}
