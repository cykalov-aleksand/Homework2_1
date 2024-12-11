package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) {
        super(nameProduct);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%20s%20d%5s%31d%4s", super.getNameProduct(), price, " руб", getPrice(), "руб");
    }
}
