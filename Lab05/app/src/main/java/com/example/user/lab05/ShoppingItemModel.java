package com.example.user.lab05;

public class ShoppingItemModel {
    private String name;
    private int price;
    private int inCart;

    public ShoppingItemModel(String name, int price) {
        this.name = name;
        this.price = price;
        this.inCart = 0;
    }

    public void buy(int amount)
    {
        this.inCart += amount;
    }

    public int getInCart() {return this.inCart;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
