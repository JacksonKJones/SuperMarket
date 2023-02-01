package com.example.supermarket;

import java.util.jar.Attributes;

public class Rating {
    private int ratingID;
    private String name;
    private String address;
    private float liquor;
    private float produce;

    public Rating(int ratingID, String name, String address, float liquor, float produce, float meat, float cheese, float checkout) {
        this.ratingID = ratingID;
        this.name = name;
        this.address = address;
        this.liquor = liquor;
        this.produce = produce;
        this.meat = meat;
        this.cheese = cheese;
        this.checkout = checkout;
    }

    public Rating(String name, String address, float liquor, float produce, float meat, float cheese, float checkout) {
        this.name = name;
        this.address = address;
        this.liquor = liquor;
        this.produce = produce;
        this.meat = meat;
        this.cheese = cheese;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Rating{" + "ratingID=" + ratingID + ", name='" + name + '\'' + ", address='" + address + '\''
                + ", liquorRating=" + liquor + ", produceRating=" + produce + ", meatRating" + meat
                + ", cheeseRating=" + cheese + ", checkoutRating=" + checkout;
    }

    public Rating() {
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getLiquor() {
        return liquor;
    }

    public void setLiquor(float liquor) {
        this.liquor = liquor;
    }

    public float getProduce() {
        return produce;
    }

    public void setProduce(float produce) {
        this.produce = produce;
    }

    public float getMeat() {
        return meat;
    }

    public void setMeat(float meat) {
        this.meat = meat;
    }

    public float getCheese() {
        return cheese;
    }

    public void setCheese(float cheese) {
        this.cheese = cheese;
    }

    public float getCheckout() {
        return checkout;
    }

    public void setCheckout(float checkout) {
        this.checkout = checkout;
    }

    private float meat;
    private float cheese;
    private float checkout;
}

