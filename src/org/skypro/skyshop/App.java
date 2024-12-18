
package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.searchengine.SearchEngine;
import org.skypro.skyshop.product.simpleprodct.SimpleProduct;
import org.skypro.skyshop.product.аrticle.Article;

public class App {
    static Product[] products = {
            new SimpleProduct("Конфеты", 800),
            new SimpleProduct("Макароны", 80),
            new SimpleProduct("Пельмени", 350),
            new SimpleProduct("Масло", 120),
            new SimpleProduct("Сосиски", 150),
            new SimpleProduct("Кетчуп", 120),
            new SimpleProduct("Майонез", 77),
            new SimpleProduct("Молоко", 70),
            new SimpleProduct("Кефир", 80),
            new SimpleProduct("Сметана", 210),
            new SimpleProduct("Яйца", 100),
            new DiscountedProduct("Мыло", 115, 10),
            new DiscountedProduct("Шампунь", 888, 10),
            new DiscountedProduct("Стиральный порошок", 780, 15),
            new DiscountedProduct("Пена для бритья", 455, 15),
            new FixPriceProduct("Хлеб ржаной"),
            new FixPriceProduct("Хлеб Бородинский"),
            new FixPriceProduct("Батон нарезной"),
            new FixPriceProduct("Туалетная бумага")
    };
    static Article[] articles = {
            new Article("Конфеты", "Конфеты Cладкоежка"),
            new Article("Макароны", "Макароны Макфа"),
            new Article("Пельмени", "Пельмени Рузские"),
            new Article("Масло", "Масло Вологодское"),
            new Article("Сосиски", "Сосиски Микояновские"),
            new Article("Кетчуп", "Кетчуп острый"),
            new Article("Майонез", "Майонез Провансаль"),
            new Article("Молоко", "Молоко Рузское"),
            new Article("Кефир", "Рузский"),
            new Article("Сметана", "Сметана домашняя"),
            new Article("Яйца", "Яйца куринные первой категории"),
            new Article("Мыло", "Мыло Palmolive"),
            new Article("Хлеб ржаной", "Хлебобулчное изделие"),
            new Article("Хлеб Бородинский", "Хлебобулочное изделие"),
            new Article("Батон нарезной", "Батон нарезной")
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
        System.out.printf("\n%20s%25s%10s%25s", "Продукт", "Цена", "Скидка", "Итоговая цена");
        System.out.println();
        for (Product variant : products) {
            System.out.println(variant);
        }
    }

    static void searchProductAddBasket(String product) {
        if (product == null || product.isBlank()) {
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

    static void searchProductBasket(String product) {
        if (product == null || product.isBlank()) {
            String error = "ОШИБКА не введено название продукта для добавления в корзину ";
            throw new IllegalArgumentException(error);
        }
        if (basket.checkProductAvailability(product)) {
            System.out.println("Товар есть в корзине");
        } else {
            System.out.println("Товара нет в корзине");
        }
    }

    public static void main(String[] args) {
        String product1 = "Хлеб ржаной";
        String product2 = "Кетчуп";
        String product3 = "Стиральный порошок";
        String product4 = "Туалетная бумага";
        String product5 = "Пена для бритья";
        String product6 = "Молоко";

        printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        printTitle("Демонстрация классов");
        printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        printProductsInStore();
        printTitle("1. Добавление продукта в корзину");
        System.out.println("Добавили 1 продукт: " + product1);
        searchProductAddBasket(product1);
        System.out.println("Добавили 2 продукт: " + product2);
        searchProductAddBasket(product2);
        System.out.println("Добавили 3 продукт: " + product3);
        searchProductAddBasket(product3);
        System.out.println("Добавили 4 продукт: " + product4);
        searchProductAddBasket(product4);
        System.out.println("Добавили 5 продукт: " + product5);
        searchProductAddBasket(product5);
        printTitle("2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        System.out.println("Добавили 6 продукт: " + product6);
        searchProductAddBasket(product6);
        printTitle("3. Печать содержимого корзины с несколькими товарами");
        basket.printContentBasket();
        printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: " + basket.calculateCostBasket() + " рублей");
        printTitle("5. Поиск товара, который есть в корзине (" + product2 + ")");
        searchProductBasket(product2);
        printTitle("6. Поиск товара, которого нет в корзине (" + product6 + ")");
        searchProductBasket(product6);
        printTitle("7. Очистка корзины");
        basket.clearingBasket();
        printTitle("8. Печать содержимого пустой корзины");
        basket.printContentBasket();
        printTitle("9. Получение стоимости пустой корзины");
        System.out.println("Стоимость пустой корзины равна: " + basket.calculateCostBasket() + " рублей");
        printTitle("10. Поиск товара по имени в пустой корзине");
        searchProductBasket(product3);


        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Полиморфизм. Интерфейсы");
        System.out.println("1. Создали один объект типа SearchEngine c пустым полем массива размером не менее (Product + Article)");
        int size = products.length + articles.length;
        System.out.println("Итого: мы выбрали массив равный " + size + " если же мы далее планируем расширять продуктовую базу, размер массива также необходимо увеличивать");
        SearchEngine searchEngeni = new SearchEngine(size);
        System.out.println("2. Привели тип объекта products к типу Searhable  и занесли элементы в объект searchEngeni  ");
        Searchable[] typeConversion = products;
        searchEngeni.add(typeConversion);
        System.out.println("3. Занесли объекты article в объект searchEngeni  ");
        searchEngeni.add(articles);
        printTitle("4. Проводим проверку заполнения объекта searchEngeni");
        for (Searchable x : searchEngeni.getSearchable()) {
            System.out.println(x);
        }

        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "ма";
        int sequenceNumber = 0;
        printTitle("5. Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        for (Searchable x : searchEngeni.search(searchOption1)) {
            try {
                System.out.println((++sequenceNumber) + "." + x.getStringRepresentation());
            } catch (NullPointerException e) {
                System.out.printf("%7s%20s%10s%20s", "Имя ", "NULL", " — тип - ", "NULL\n");
            }
        }
        sequenceNumber = 0;
        printTitle("6. Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        for (Searchable x : searchEngeni.search(searchOption2)) {
            try {
                System.out.println((++sequenceNumber) + "." + x.getStringRepresentation());
            } catch (NullPointerException e) {
                System.out.printf("%7s%20s%10s%20s", "Имя ", "NULL", " — тип - ", "NULL\n");
            }
        }
        sequenceNumber = 0;
        System.out.println("7. Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 + ", на предмет полного заполнения массива поиска \n");
        for (Searchable x : searchEngeni.search(searchOption3)) {
            try {
                System.out.println((++sequenceNumber) + "." + x.getStringRepresentation());
            } catch (NullPointerException e) {
                System.out.printf("%7s%20s%10s%20s", "Имя ", "NULL", " — тип - ", "NULL\n");
            }
        }
    }
}
