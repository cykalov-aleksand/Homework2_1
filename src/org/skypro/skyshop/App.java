
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    static Product[] products = {
            new Product("Хлеб", 90),
            new Product("Макароны", 80),
            new Product("Пельмени", 350),
            new Product("Масло", 120),
            new Product("Сосиски", 150),
            new Product("Кетчуп", 120),
            new Product("Майонез", 77),
            new Product("Молоко", 70),
            new Product("Кефир", 80),
            new Product("Сметана", 210),
            new Product("Яйца", 100)
    };
    static ProductBasket basket = new ProductBasket();

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }

    static void printProductsInStore() {
        System.out.printf("\n%15s%25s", "Продукт", "Цена");
        System.out.println();
        for (Product variant : products) {
            System.out.println(variant);
        }
    }

    static void searchProductAddBasket(String product) {
        if (product==null||product.isBlank()){
            String error = "ОШИБКА не введено название продукта для добавления в корзину ";
            throw new IllegalArgumentException(error);
        }
        boolean availabilityProduct = false;
        for (int i = 0; i < products.length; i++) {
            if (product.trim().equalsIgnoreCase(products[i].getNameProduct().trim())) {
                availabilityProduct = true;
                basket.addProduct(products[i]);
            }
        }
        if (!availabilityProduct) {
            System.out.println("В магазине такого товара нет");
        }
    }
    static void searchProductBasket(String product){
        if (product==null||product.isBlank()){
            String error = "ОШИБКА не введено название продукта для добавления в корзину ";
            throw new IllegalArgumentException(error);
        }
        if(basket.checkProductAvailability(product)){
            System.out.println("Товар есть в корзине");
        }else {
            System.out.println("Товара нет в корзине");
        }
    }

    public static void main(String[] args) {
        String product1="кефир";
        String product2="молоко";
        String product3="сметана";
        String product4="яйца";
        String product5="сосиски";
        String product6="хлеб";

        printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        printTitle("Демонстрация классов");
        printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        printProductsInStore();
        printTitle("1. Добавление продукта в корзину");
        System.out.println("Добавили 1 продукт: "+product1);
        searchProductAddBasket(product1);
        System.out.println("Добавили 2 продукт: "+product2);
        searchProductAddBasket(product2);
        System.out.println("Добавили 3 продукт: "+product3);
        searchProductAddBasket(product3);
        System.out.println("Добавили 4 продукт: "+product4);
        searchProductAddBasket(product4);
        System.out.println("Добавили 5 продукт: "+product5);
        searchProductAddBasket(product5);
        printTitle("2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        System.out.println("Добавили 6 продукт: "+product6);
        searchProductAddBasket(product6);
        printTitle("3. Печать содержимого корзины с несколькими товарами");
               basket.printContentBasket();
        printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: "+basket.calculateCostBasket()+ " рублей");
        printTitle("5. Поиск товара, который есть в корзине ("+product2+")");
        searchProductBasket(product2);
        printTitle("6. Поиск товара, которого нет в корзине ("+product6+")");
        searchProductBasket(product6);
        printTitle("7. Очистка корзины");
        basket.clearingBasket();
        printTitle("8. Печать содержимого пустой корзины");
        basket.printContentBasket();
        printTitle("9. Получение стоимости пустой корзины");
        System.out.println("Стоимость пустой корзины равна: "+basket.calculateCostBasket()+ " рублей");
        printTitle("10. Поиск товара по имени в пустой корзине");
        searchProductBasket(product3);

    }
}
