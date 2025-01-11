package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, ArrayList<Product>> products = new HashMap<>();

    public void addProduct(Product titleProduct) {
        products.computeIfAbsent(titleProduct.getNameProduct(), k -> new ArrayList<>());
        products.get(titleProduct.getNameProduct()).add(titleProduct);
    }

    public int calculateCostBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
            return 0;
        }
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printContentBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
        } else {
            System.out.printf("\n%20s%23s%10s%28s", "Продукт", "Цена", "Скидка", "Итоговая цена\n");
            products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            int count = (int) products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
            System.out.printf("%20s%20d%5s\n%20s%5d", "Итого: ", calculateCostBasket(), " руб", "Специальных товаров: ", count);
        }
    }

    public List<Product> deleteProduct(String line) {
        List<Product> delete = new ArrayList<>();
        if (products.isEmpty()) {
            System.out.println("В корзине нет продуктов");
        } else {
            delete = products.values().stream().flatMap(Collection::stream).filter((o) -> o.getNameProduct().toLowerCase()
                    .contains(line.toLowerCase().trim())).filter(Objects::nonNull).collect(Collectors.toList());
            products.values().stream().flatMap(Collection::stream).filter((o) -> o.getNameProduct().toLowerCase()
                    .contains(line.toLowerCase().trim())).forEach(o -> o = null);
        }
        return delete;
    }

    public boolean checkProductAvailability(String product) {
        if (product.isBlank()) {
            System.out.println("Не введено название поиска товара в корзине");
            return false;
        }
        if (products.isEmpty()) {
            System.out.println("Корзина пуста!!!");
            return false;
        } else {
            return products.keySet().stream().anyMatch(o -> o.trim().equalsIgnoreCase(product.trim()));
        }
    }

    public void clearingBasket() {
        products.clear();
        System.out.println("Корзина очищена!!!");
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        ProductBasket that = (ProductBasket) object;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }
}
