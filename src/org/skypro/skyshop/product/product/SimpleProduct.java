package org.skypro.skyshop.product.product;

public class SimpleProduct extends Product {
    private int price;

    public SimpleProduct(String nameProduct, int price) throws IllegalArgumentException {
        super(nameProduct);
        if (price <= 0) {
            throw new IllegalArgumentException("ОШИБКА В ЦЕНЕ ТОВАРА  " + super.getNameProduct());
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("%30s%20d%5s%31d%4s", super.getNameProduct(), price, " руб", getPrice(), "руб");
    }
}
