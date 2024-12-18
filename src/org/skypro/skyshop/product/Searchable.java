package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTemp();
    String getContentType();
    default String getStringRepresentation(){
        return String.format("%5s%20s%10s%20s","Имя ",getSearchTemp()," — тип - ", getContentType());
    }
}
