package com.example.supermarket;

public class RatingModel {
    private String name;
    private String address;
    private float liquorRating;
    private float produceRating;
    private float meatRating;
    private float cheeseRating;
    private float checkoutRating;

    public RatingModel(String name, String address, float liquorRating, float produceRating, float meatRating, float cheeseRating, float checkoutRating) {
        this.name = name;
        this.address = address;
        this.liquorRating = liquorRating;
        this.produceRating = produceRating;
        this.meatRating = meatRating;
        this.cheeseRating = cheeseRating;
        this.checkoutRating = checkoutRating;
    }

    public RatingModel(String name, String address) {
        this.name = name;
        this.address = address;
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

    public float getLiquorRating() {
        return liquorRating;
    }

    public void setLiquorRating(float liquorRating) {
        this.liquorRating = liquorRating;
    }

    public float getProduceRating() {
        return produceRating;
    }

    public void setProduceRating(float produceRating) {
        this.produceRating = produceRating;
    }

    public float getMeatRating() {
        return meatRating;
    }

    public void setMeatRating(float meatRating) {
        this.meatRating = meatRating;
    }

    public float getCheeseRating() {
        return cheeseRating;
    }

    public void setCheeseRating(float cheeseRating) {
        this.cheeseRating = cheeseRating;
    }

    public float getCheckoutRating() {
        return checkoutRating;
    }

    public void setCheckoutRating(float checkoutRating) {
        this.checkoutRating = checkoutRating;
    }
}
