package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.product.Product;

import java.util.*;

public class ProductBasket {
    LinkedList<Product> products = new LinkedList<>();
    public void addProduct(Product titleProduct) {
        products.add(titleProduct);
        System.out.println("Продукт в корзину добавлен");
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
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
        } else {
            System.out.printf("\n%20s%23s%10s%28s", "Продукт", "Цена", "Скидка", "Итоговая цена\n");
            for (Product variable : products) {
                if (variable.isSpecial()) {
                    counterIsSpecial++;
                }
                System.out.println(variable);
            }
            System.out.printf("%20s%20d%5s", "Итого:", calculateCostBasket(), " руб");
            System.out.printf("\n%20s%10d%5s", "Специальных товаров:", counterIsSpecial, " наименования(е)");
        }
    }

    public List<Product> deleteProduct(String line) {
        List<Product> delete = new ArrayList<>();
        if (products.isEmpty()) {
            System.out.println("В корзине нет продуктов");
        } else {
            for (Product variable : products) {
                if (variable.getNameProduct().toLowerCase().contains(line.toLowerCase().trim())) {
                    delete.add(variable);
                    products.remove();
                }
            }
        }
        return delete;
    }

    public boolean checkProductAvailability( String product) {
        if (product == null || product.isBlank()) {
            String error = "ОШИБКА не введено название продукта для добавления в корзину ";
            throw new IllegalArgumentException(error);
        }
        if (products.isEmpty()) {
            System.out.println("Корзина пуста");
            return false;
        }
        for (Product variable : products) {
            if (product.trim().equalsIgnoreCase(variable.getNameProduct().trim())) {
                return true;
            }
        }
        return false;
    }

    public void clearingBasket() {
        products.clear();
        System.out.println("Корзина очищена");
    }
}
