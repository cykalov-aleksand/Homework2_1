package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountProcent;

    public DiscountedProduct(String nameProduct, int basePrice, int discountProcent) {
        super(nameProduct);
        this.basePrice = basePrice;
        this.discountProcent = discountProcent;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - discountProcent / 100f));
    }

    @Override
    public String toString() {
        return String.format("%20s%20d%5s%5d%3s%23d%4s", super.getNameProduct(), basePrice, " руб", discountProcent, "%", getPrice(), "руб");

    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
