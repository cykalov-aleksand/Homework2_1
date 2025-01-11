
package org.skypro.skyshop;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.product.product.Product;
import org.skypro.skyshop.product.searchengine.SearchEngine;

import java.util.*;

public class App {
    static ConsolPrint print = new ConsolPrint();

     static void completeTask1(ProductInformation productInformation) {
        String product1 = "Хлеб ржаной";
        String product2 = "Хлеб нарезной";
        String product3 = "Стиральный порошок";
        print.printTitle("ДОМАШНЕЕ ЗАДАНИЕ");
        print.printTitle("Демонстрация классов");
        print.printTitle("Создали некоторый массив продуктов имеющихся в магазине вывели его на экран");
        productInformation.printProductsInStore();
        initialFillingOfBasket(productInformation);
        print.printTitle("3. Печать содержимого корзины с несколькими товарами");
        productInformation.basket.printContentBasket();
        print.printTitle("4. Получение стоимости корзины с несколькими товарами");
        System.out.println("Стоимость корзины с отложенными товарами равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        print.printTitle("5. Поиск товара, который есть в корзине (" + product1 + ")");
        productInformation.searchProductBasket(product1);
        print.printTitle("6. Поиск товара, которого нет в корзине (" + product2 + ")");
        productInformation.searchProductBasket(product2);
        print.printTitle("7. Очистка корзины");
        productInformation.basket.clearingBasket();
        print.printTitle("8. Печать содержимого пустой корзины");
        productInformation.basket.printContentBasket();
        print.printTitle("9. Получение стоимости пустой корзины");
        print.printLine("Стоимость пустой корзины равна: " + productInformation.basket.calculateCostBasket() + " рублей");
        print.printTitle("10. Поиск товара по имени в пустой корзине");
        productInformation.searchProductBasket(product3);
    }

    static void completeTask2(ProductInformation productInformation, SearchEngine searchEngeni) {
        print.printTitle("ДОМАШНЕЕ ЗАДАНИЕ Полиморфизм. Интерфейсы");
        print.printTitle("1. Создали один объект типа SearchEngine c пустым списком ");
        print.printLine(1, "Итого: мы имеем список размерностью изначально равной " + searchEngeni.getSearchable().size());
        print.printTitle("2. Привели тип объекта products к типу Searhable  и занесли элементы в объект searchEngeni  ");
        searchEngeni.add(productInformation.products);
        print.printTitle("3. Занесли объекты article в объект searchEngeni  ");
        searchEngeni.add(productInformation.articles);
        print.printTitle("4. Проводим проверку заполнения объекта searchEngeni");
        for (Searchable x : searchEngeni.getSearchable()) {
            System.out.println(x);
        }
        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "ма";
        print.printTitle("5. Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        demonstrateTheMethod(searchEngeni, searchOption1);
        print.printTitle("6. Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        demonstrateTheMethod(searchEngeni, searchOption2);
        print.printLine("7. Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 + ", на предмет полного заполнения массива поиска \n");
        demonstrateTheMethod(searchEngeni, searchOption3);
    }

    static void completeTask3(ProductInformation productInformation, SearchEngine searchEngeni) {
        String searchOption4 = "майонез";
        String searchOption5 = "apple";
        print.printTitle("ДОМАШНЕЕ ЗАДАНИЕ Исключение в JAVA");
        print.printLine(1, "1. В классы Product и его наследники ввели проверку корректности ввода данных в объекты.");
        print.printLine(1, "2. Провели демонстрацию корректности ввода данных без ошибки для удобства проверки данных при вводе ошибки в программу.");
        productInformation.printProductsInStore();
        print.printLine(1, "3. 4. Реализовали метод getSearchTerm(String search) в классе Searchable и создали исключение BestResultNotFound. ");
        print.printTitle("5.1 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption4);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption4);
        print.printTitle("5.2 Продемонстрируем метод getSearchTerm(String search) когда строка имеет значение - " + searchOption5);
        System.out.println();
        demonstrateTheMethod2(searchEngeni, searchOption5);

    }

    static void completeTask4(ProductInformation productInformation, SearchEngine searchEngeni) {
        print.printTitle("ДОМАШНЕЕ ЗАДАНИЕ Java Collections Framework: List");
        print.printLine(1, "1.1 Поменяли внутреннюю структуру класса ProductBasket заменили массив на список типа  LinkedList");
        print.printLine(1, "1.2 Убедились что теперь мы можем в корзину добавлять условно бесконечное количество продуктов");
        ArrayList<String> productBasket = new ArrayList<>();
        productBasket.add("Хлеб ржаной");
        productBasket.add("Кетчуп");
        productBasket.add("Стиральный порошок");
        productBasket.add("Туалетная бумага");
        productBasket.add("Пена для бритья");
        productBasket.add("Молоко");
        print.printLine("1. Добавление продукта в корзину");
        for (int element = 0; element < productBasket.size(); element++) {
            System.out.println("Добавили " + (element + 1) + " продукт: " + productBasket.get(element));
            productInformation.searchProductAddBasket(productBasket.get(element));
        }
        print.printLine(1, "2. Добавили метод public deleteProduct(String line), который по переданному имени продукта удаляет все" +
                " продукты с таким именем из корзины");
        print.printLine(1, "2.1 Продемонстрируем работу метода. Для этого распечатаем содержимое корзины.");
        productInformation.basket.printContentBasket();
        System.out.println();
        String productDelete = "молоко";
        print.printLine(1, "\n 2.1 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
        printDeleteProductBasket(productInformation, productDelete);
        print.printLine(1, "2.2. Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
        productInformation.basket.printContentBasket();
        productDelete = "пенt для бритья";
        print.printLine(1, "\n 2.3 Удалим из корзины продукт введенный с ошибкой \" "
                + productDelete + "\" и выведем в консоль удаленные продукты с корзины.\n");
        printDeleteProductBasket(productInformation, productDelete);
        print.printLine("2.4. Вывели содержимое корзины на экран.");
        productInformation.basket.printContentBasket();
        searchEngeni.clearSearchEngine();
        print.printLine(1, "\n3. Продемонстрируем использование измененного метода search " +
                "для чего повторим вывод домашнего задания \"Полиморфизм. Интерфейсы.\" на печать");
        print.printLine(1, "Для повторного корректного выполнения домашнего задания \"Полиморфизм. Интерфейсы.\" " +
                "произвел предварительно очистку списка объекта searchEngine дополнительным методом clearSearchEngine()  ");
        searchEngeni.clearSearchEngine();
        completeTask2(productInformation, searchEngeni);
        System.out.println("\nУбедились что программа отрабатывает согласно условия задания.");
    }

    static void completeTask5(ProductInformation productInformation, SearchEngine searchEngeni) {
        print.printTitle("Java Collections Framework: Map");
        print.printTitle("1. Изменение используемой структуры данных в классе ProductBacket");
        System.out.println();
        print.printLine(1, " 1.1 Произвели изменения в классе ProductBasket заменили тип переменной products на\n" +
                "тип: Map<String, ArrayList<Product>> ");
        print.printLine(1, "Для контроля корректности работы класса ProductBasket выведем на консоль" +
                " условия работы домашнего задания \"Введение в ООП. Инкапсуляция\" ");
        completeTask1(productInformation);
        System.out.println();
        print.printLine(1, "1.2 Продемонстрировали работу класса за исключением удаления продукта с корзины. Произведем данную проверку.\n");
        print.printLine(1, "Для чего, вновь заполним корзину продуктами.\n");
        initialFillingOfBasket(productInformation);
        print.printLine(1, "1.3 Выведем на консоль содержимое корзины до удаления товара\n");
        productInformation.basket.printContentBasket();
        String productDelete = "конфеты";
        print.printLine(1, "\n 1.5 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
        printDeleteProductBasket(productInformation, productDelete);
        print.printLine(1, "1.6 Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
        productInformation.basket.printContentBasket();
        print.printTitle("2. Модификация возвращаемого значения в методе поиска");
        print.printLine(1, "Продемонстрируем работу метода search");
        String searchOption1 = "хлеб";
        String searchOption2 = "майонез";
        String searchOption3 = "a";
        print.printLine(1, "2.1 Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 + " ");
        demonstrateTheMethod(searchEngeni, searchOption1);
        print.printLine(1, "2.2 Продемонстрировали функциональность поиска при вводе строки - " + searchOption2 + " ");
        demonstrateTheMethod(searchEngeni, searchOption2);
        print.printLine(1, "2.3 Продемонстрировали функциональность поиска при вводе строки - " + searchOption3 +
                ", на предмет сортировки выводимой информации по ключу Set поиска \n");
        demonstrateTheMethod(searchEngeni, searchOption3);
    }

    static void completeTask6(ProductInformation productInformation, SearchEngine searchEngeni) {
        print.printTitle("Java Collections Framework: Set");
        print.printTitle("1.Произвели замену List на Set в классе SearchEnable.");
        print.printLine("2. Реализовали equals и hashCode в классах Product  и Article");
        print.printLine("3. Для демонстрации того, что продуктов и статей с одинаковым именем не существует в объекте класса SearchEngine, ");
        print.printLine("добавим в массивы данных одинаковые строки \"кетчуп\" в Article и \" и батон нарезной 4 кат.\" в массиве product" + "\n" +
                "и пройдем по объекту в поиске указанных строк и при наличии выведем в консоль");
        String controlLine1 = "кетчуп";
        print.printTitle(" 3.1 первая проверка по строке " + controlLine1);
        checkingStringSearhEngine(productInformation.searchEngeni, controlLine1);
        String controlLine2 = "батон нарезной 4 кат";
        print.printTitle(" 3.2 вторая проверка по строке " + controlLine2);
        checkingStringSearhEngine(productInformation.searchEngeni, controlLine2);
        print.printLine(1, "Убедились что в консоль выводится информация по одному продукту ");
        print.printLine("3.3 сравним сумму элементов массивов article и product с количеством элементов в объекте класса SearchEngine");
        int numberArrays = productInformation.articles.length + productInformation.products.length;
        print.printLine(1, "Сумма элементов массива article и product равна: " + numberArrays);
        int numberGetSearhable = productInformation.searchEngeni.getSearchable().size();
        print.printLine(1, "Количество элементов в объекте класса SearchEngine равно: " + numberGetSearhable);
        print.printLine(1, "Итого в массивах article и product " + (numberArrays - numberGetSearhable) + " одинаковых строк не вошедших в объект класса SearchEngine.");
        print.printTitle("Проверим работу КОМПОРАТОРА");
        String searchOption1 = "майонез";
        String searchOption2 = "хлеб";
        String searchOption3 = "а";
        print.printLine("\n4.1 Продемонстрировали функциональность поиска при вводе строки - " + searchOption1 +
                ", на предмет сортировки выводимой информации по ключу Set поиска \n");
        demonstrateTheMethod(productInformation.searchEngeni, searchOption1);
        print.printLine(1, "Убедились что фильтрация производится от большего количества строк к меньшему и строки с одинаковым количеством элементов сортируются в натуральном порядке");
        print.printLine("\n4.2 Продемонстрируем функциональность поиска при вводе продукта - " + searchOption2);
        demonstrateTheMethod(productInformation.searchEngeni, searchOption2);
        print.printLine("\n4.3 Продемонстрируем функциональность поиска при вводе продукта - " + searchOption3);
        demonstrateTheMethod(productInformation.searchEngeni, searchOption3);
        System.out.println();
        print.printLine(1, "В результате демонстрации метода фильтрации по букве \"а\" наблюдаем, что фильтрация производится согласно условия задачи." +
                " Элементы Article выводятся в тех случаях, когда слово встречается в названии текста статьи, а не названия продукта.");
    }

    static void demonstrateTheMethod(SearchEngine object, String line) {
        for (Searchable variant : object.search(line)) {
            System.out.printf("%5s%30s%10s%30s\n", "Имя ", variant.sortingElement(), " — тип - ", variant.getContentType());
        }
    }

    static void demonstrateTheMethod2(SearchEngine object, String line) {
        try {
            System.out.println(object.getSearchTerm(line).getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }
    }

    static void printDeleteProductBasket(ProductInformation object, String line) {
        int index = 0;
        for (Product element : object.basket.deleteProduct(line)) {
            index++;
            System.out.println(element);
        }
        if (index == 0) {
            System.out.println("Список пуст, проверьте правильность ввода строки удаления");
        }
    }

    static void initialFillingOfBasket(ProductInformation object) {
        List<String> productN = new ArrayList<>();
        productN.add("Хлеб ржаной");
        productN.add("конфеты");
        productN.add("Стиральный порошок");
        productN.add("Туалетная бумага");
        productN.add("Пена для бритья");
        productN.add("Молоко");
        productN.add("Стиральный порошок");
        productN.add("конфеты");
        productN.add("Пена для бритья");
        productN.add("конфеты");
        productN.add("Пена для бритья");
        productN.add("Батон нарезной 1 кат");
        productN.add("Батон нарезной 1 кат");
        productN.add("Батон нарезной 2 кат");
        productN.add("Батон нарезной 3 кат");
        productN.add("Батон нарезной 4 кат");
        for (int variable = 0; variable < productN.size(); variable++) {
            System.out.println("Добавили " + (variable + 1) + " продукт: " + productN.get(variable));
            object.searchProductAddBasket(productN.get(variable));
        }
    }

    static void checkingStringSearhEngine(SearchEngine object, String line) {
        for (Searchable variable : object.getSearchable()) {
            if (variable.getSearchTemp().toLowerCase().trim().contains(line.toLowerCase().trim())) {
                System.out.println(variable);
            }
        }
    }

    public static void main(String[] args) {
        try {
            ProductInformation productInformation = new ProductInformation();
            completeTask1(productInformation);
            completeTask2(productInformation, productInformation.searchEngeni);
            completeTask3(productInformation, productInformation.searchEngeni);
            completeTask4(productInformation, productInformation.searchEngeni);
            completeTask5(productInformation, productInformation.searchEngeni);
            completeTask6(productInformation, productInformation.searchEngeni);
            print.printTitle("ДОМАШНЕЕ ЗАДАНИЕ Stream API и лямбда-выражения");
            print.printLine("1. Изменили метод search в поисковом движке, результат его работы наблюдаем в пункте 4.3");
            print.printLine("2. Произвели изменения методов в классе ProductBasket, для проверки работы этих методов выведем на консоль домашнее задание с добавлением продуктов в корзину ");
            completeTask1(productInformation);
            print.printLine("2.2 Продемонстрировали работу класса за исключением удаления продукта с корзины. Произведем данную проверку.");
            print.printLine("Для чего, вновь заполним корзину продуктами.\n");
            initialFillingOfBasket(productInformation);
            print.printLine("2.3 Выведем на консоль содержимое корзины до удаления товара\n");
            productInformation.basket.printContentBasket();
            String productDelete = "конфеты";
            print.printLine(" 2.4 Удалим из корзины один продукт \" " + productDelete + "\" и выведем в консоль удаленные продукты с корзины.");
            printDeleteProductBasket(productInformation, productDelete);
            print.printTitle("2.5 Распечатаем содержимое корзины и убедимся в отсутствии в ней продукта \"" + productDelete + "\"");
            productInformation.basket.printContentBasket();
            print.printLine("Убедились что все методы работают в соответствии с условием.");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + "  проведите корректировку вводимых данных.");
        } catch (NullPointerException e) {
            System.err.println(e.getMessage());
        }
    }
}
//Для уменьшения количества продуктов в корзине замените в методе initialFillingOfBasket() число повторений в цикле
// for (int variable = 0; variable < productN.size(); variable++); productN.size() - на необходимое число продуктов в корзине