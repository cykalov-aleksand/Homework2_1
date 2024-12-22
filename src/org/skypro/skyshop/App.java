
package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.searchengine.SearchEngine;

public class App {

    static void printTitle(String title) {
        int lineLength = 100;
        int headerLength = title.length();
        int numberOfCharacters = (lineLength - headerLength) / 2;
        String completion = "-";
        System.out.println("\n" + completion.repeat(numberOfCharacters) + title + completion.repeat(numberOfCharacters));
    }

    static void completeTask1(ProductInformation productInformation) {
        String product1 = "Хлеб ржаной";
        String product2 = "Кетчуп";
        String product3 = "Стиральный порошок";
        String product4 = "Туалетная бумага";
        String product5 = "Пена для бритья";
        String product6 = "Молоко";
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        printTitle("Демонстрация классов");
        printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        productInformation.printProductsInStore();
        printTitle("1. Добавление продукта в корзину");
        System.out.println("Добавили 1 продукт: " + product1);
        productInformation.searchProductAddBasket(product1);
        System.out.println("Добавили 2 продукт: " + product2);
        productInformation.searchProductAddBasket(product2);
        System.out.println("Добавили 3 продукт: " + product3);
        productInformation.searchProductAddBasket(product3);
        System.out.println("Добавили 4 продукт: " + product4);
        productInformation.searchProductAddBasket(product4);
        System.out.println("Добавили 5 продукт: " + product5);
        productInformation.searchProductAddBasket(product5);
        printTitle("2. Добавление продукта в заполненную корзину, в которой нет свободного места");
        System.out.println("Добавили 6 продукт: " + product6);
        productInformation.searchProductAddBasket(product6);
        printTitle("3. Печать содержимого корзины с несколькими товарами");
        productInformation.basket.printContentBasket();
        printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("5. Поиск товара, который есть в корзине (" + product2 + ")");
        productInformation.searchProductBasket(product2);
        printTitle("6. Поиск товара, которого нет в корзине (" + product6 + ")");
        productInformation.searchProductBasket(product6);
        printTitle("7. Очистка корзины");
        productInformation.basket.clearingBasket();
        printTitle("8. Печать содержимого пустой корзины");
        productInformation.basket.printContentBasket();
        printTitle("9. Получение стоимости пустой корзины");
        System.out.println("Стоимость пустой корзины равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        printTitle("10. Поиск товара по имени в пустой корзине");
        productInformation.searchProductBasket(product3);
    }

    static void completeTask2(ProductInformation productInformation, SearchEngine searchEngeni) {
        printTitle("ДОМАШНЕЕ ЗАДАНИЕ Полиморфизм. Интерфейсы");
        System.out.println("1. Создали один объект типа SearchEngine c пустым полем массива размером не менее (Product + Article)");
        System.out.println("Итого: мы выбрали массив равный " + searchEngeni.getSearchable().length + " если же мы далее планируем расширять продуктовую базу, размер массива также необходимо увеличивать");
        System.out.println("2. Привели тип объекта products к типу Searhable  и занесли элементы в объект searchEngeni  ");
        Searchable[] typeConversion = productInformation.products;
        searchEngeni.add(typeConversion);
        System.out.println("3. Занесли объекты article в объект searchEngeni  ");
        searchEngeni.add(productInformation.articles);
        printTitle("4. Проводим проверку заполнения объекта searchEngeni");
        for (Searchable x : searchEngeni.getSearchable()) {
            System.out.println(x);
        }
        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "ма";
        printTitle("5. Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        demonstrateTheMethod(searchEngeni, searchOption1);
        printTitle("6. Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        demonstrateTheMethod(searchEngeni, searchOption2);
        System.out.println("7. Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 + ", на предмет полного заполнения массива поиска \n");
        demonstrateTheMethod(searchEngeni, searchOption3);

    }

    static void demonstrateTheMethod(SearchEngine object, String line) {
        int sequenceNumber = 0;
        for (Searchable x : object.search(line)) {
            try {
                System.out.println((++sequenceNumber) + "." + x.getStringRepresentation());
            } catch (NullPointerException e) {
                System.out.printf("%7s%20s%10s%20s", "Имя ", "NULL", " — тип - ", "NULL\n");
            }
        }
    }

    static void demonstrateTheMethod2(SearchEngine object, String line) {
        try {
            System.out.println(object.getSearchTerm(line).getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        try {
            ProductInformation productInformation = new ProductInformation();
            int size = productInformation.products.length + productInformation.articles.length;
            SearchEngine searchEngeni = new SearchEngine(size);
            completeTask1(productInformation);
            completeTask2(productInformation, searchEngeni);
            String searchOption4 = "майонез";
            String searchOption5 = "apple";
            printTitle("ДОМАШНЕЕ ЗАДАНИЕ Исключение в JAVA");
            System.out.println("1. В классы Product и его наследники ввели проверку корректности ввода данных в объекты.");
            System.out.println("2. Провели демонстрацию корректности ввода данных без ошибки для удобства проверки данных при вводе ошибки в программу.");
            productInformation.printProductsInStore();
            System.out.println("3. 4. Реализовали метод getSearchTerm(String search) в классе Searchable и создали исключение BestResultNotFound. ");
            printTitle("5.1 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption4);
            System.out.println();
            demonstrateTheMethod2(searchEngeni, searchOption4);
            printTitle("5.2 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption5);
            System.out.println();
            demonstrateTheMethod2(searchEngeni, searchOption5);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage() + "  проведите корректировку вводимых данных");

        }
    }
}
//Для контроля работы прерывания необходимо вводить ошибку в класс ProductInformation находящийся по адресу org.skypro.skyshop.product;