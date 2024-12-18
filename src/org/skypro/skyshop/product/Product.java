package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private String nameProduct;

    public Product(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public abstract int getPrice();

    public boolean isSpecial() {
        return false;
    }
    public String getSearchTemp(){
                  return nameProduct;
        }
    public String getContentType(){
               return "PRODUCT";
         }

}
