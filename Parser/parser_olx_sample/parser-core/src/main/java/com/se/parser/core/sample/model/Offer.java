package com.se.parser.core.sample.model;

/**
 * Заголовок объявления
 */
public class Offer {
    private int dataId;
    private String name;
    private String category;
    private String location;
    private String date;
    private String offerImage;
    private String linkUrl;
    private String price;
    private boolean isPromoted;

    public Offer() {
    }

    /**
     *
     * @param dataId
     * @param name
     * @param category
     * @param location
     * @param date
     * @param offerImage
     * @param linkUrl
     * @param price
     * @param isPromoted
     */
    public Offer(int dataId, String name, String category, String location, String date, String offerImage,
                 String linkUrl, String price, boolean isPromoted) {
        this.dataId = dataId;
        this.name = name;
        this.category = category;
        this.location = location;
        this.date = date;
        this.offerImage = offerImage;
        this.linkUrl = linkUrl;
        this.price = price;
        this.isPromoted = isPromoted;
    }

    public int getDataId() {
        return dataId;
    }

    public void setDataId(int dataId) {
        this.dataId = dataId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOfferImage() {
        return offerImage;
    }

    public void setOfferImage(String offerImage) {
        this.offerImage = offerImage;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isPromoted() {
        return isPromoted;
    }

    public void setPromoted(boolean promoted) {
        isPromoted = promoted;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "dataId='" + dataId + '\'' +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", offerImage='" + offerImage + '\'' +
                ", linkUrl='" + linkUrl + '\'' +
                ", price='" + price + '\'' +
                ", isPromoted=" + isPromoted +
                '}';
    }
}
