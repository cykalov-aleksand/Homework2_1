package org.skypro.skyshop.product.product;

public class FixPriceProduct extends Product {
    private final int FIX_PRICE = 100;

    public FixPriceProduct(String nameProduct) {
        super(nameProduct);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE;
    }

    @Override
    public String toString() {
        return String.format("%30s%20d%5s%23s%8d%4s", super.getNameProduct(), FIX_PRICE, " руб", "(ФИКСИРОВАННАЯ ЦЕНА)", getPrice(), "руб");
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}