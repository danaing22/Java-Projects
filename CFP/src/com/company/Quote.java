package com.company;

public class Quote {
    // need the name of the website and price they're offering
    private final String site;
    private final int price;

    public Quote(String site, int price) {
        this.site = site;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getSite() {
        return site;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "site='" + site + '\'' +
                ", price=" + price +
                '}';
    }
}
