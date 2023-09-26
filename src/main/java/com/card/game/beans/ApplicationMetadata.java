package com.card.game.beans;

public class ApplicationMetadata {

    private String brand;
    private String logo;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "ApplicationMetadata{" +
                "brand='" + brand + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
