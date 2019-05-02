package com.se.parser.core.sample.parser.utils;

public class BaseSearch {
    private OfferType offerType;
    private int pageNumder;

    public BaseSearch(int pageNumder) {
        offerType = OfferType.all;
        this.pageNumder = pageNumder;
    }

    public BaseSearch(OfferType offerType, int pageNumder) {
        this.offerType = offerType;
        this.pageNumder = pageNumder;
    }

    public int getPageNumder() {
        return pageNumder;
    }

    public void setPageNumder(int pageNumder) {
        this.pageNumder = pageNumder;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (offerType != OfferType.all || pageNumder > 1) {
            builder.append("?");
        }

        switch (offerType) {
            case isBusines: {
                builder.append("search%5Bprivate_business%5D=private");
            }
            case isPrivate: {
                builder.append("search%5Bprivate_business%5D=business");
            }
        }

        if (pageNumder > 1) {
            builder.append(String.format("page=%s", pageNumder));
        }

        return builder.toString();
    }
}
