package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTemp();

    String getContentType();

    String requestForSingleField();

    default String getStringRepresentation() {
        return String.format("%5s%42s%10s%20s", "Имя ", getSearchTemp(), " — тип - ", getContentType());
    }
}
