package org.skypro.skyshop.product;
public class Product {
    private  String nameProduct;
    private  int costProduct;

    public Product(String nameProduct, int costProduct) {
        this.nameProduct = nameProduct;
        this.costProduct = costProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getCostProduct() {
        return costProduct;
    }

    @Override
    public String toString() {
        return String.format("%15s%20d%5s", this.nameProduct,costProduct, " руб");
    }

}
