package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private final Product[] products = new Product[5];
    private int quantityProduct = 0;

    public void addProduct(Product titleProduct) {
        if (quantityProduct == products.length) {
            System.out.println("Невозможно добавить продукт - корзина полна, продукт не добавлен");
        } else {
            products[quantityProduct] = titleProduct;
            quantityProduct++;
            System.out.println("Продукт в корзину добавлен");
        }

    }

    public int calculateCostBasket() {
        int summa = 0;
        for (Product product : products) {
            if (product != null) {
                summa += product.getPrice();
            } else {
                return summa;
            }
        }
        return summa;
    }

    public void printContentBasket() {
        int counterIsSpecial = 0;
        if (quantityProduct == 0) {
            System.out.println("В корзине пусто");
        } else {
            System.out.printf("\n%20s%23s%10s%28s", "Продукт", "Цена", "Скидка", "Итоговая цена\n");
            for (int i = 0; i < quantityProduct; i++) {
                if (products[i].isSpecial()) {
                    counterIsSpecial++;
                }
                System.out.println(products[i]);
            }
            System.out.printf("%20s%20d%5s", "Итого:", calculateCostBasket(), " руб");
            System.out.printf("\n%20s%10d%5s", "Специальных товаров:", counterIsSpecial, " наименования(е)");
        }
    }

    public boolean checkProductAvailability(String product) {
        if (product == null || product.isBlank()) {
            String error = "ОШИБКА не введено название продукта для добавления в корзину ";
            throw new IllegalArgumentException(error);
        }
        if (quantityProduct == 0) {
            System.out.println("Корзина пуста");
            return false;
        }
        for (int i = 0; i < quantityProduct; i++) {
            if (product.trim().equalsIgnoreCase(products[i].getNameProduct().trim())) {
                return true;
            }
        }
        return false;
    }

    public void clearingBasket() {
        quantityProduct = 0;
        Arrays.fill(products, null);
        System.out.println("Корзина очищена");
    }
}
