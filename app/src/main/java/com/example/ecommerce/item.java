package com.example.ecommerce;

public class item {
    int ownerphoto;
    int rating;
    int shopbackground;
    String shopname;

    public item(int shopbackground, String shopname, int ownerphoto, int rating) {
        this.shopbackground = shopbackground;
        this.shopname = shopname;
        this.ownerphoto = ownerphoto;
        this.rating = rating;
    }

    public int getOwnerphoto() {
        return this.ownerphoto;
    }

    public int getRating() {
        return this.rating;
    }

    public int getShopbackground() {
        return this.shopbackground;
    }

    public String getShopname() {
        return this.shopname;
    }

    public void setOwnerphoto(int ownerphoto) {
        this.ownerphoto = ownerphoto;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setShopbackground(int shopbackground) {
        this.shopbackground = shopbackground;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
}
