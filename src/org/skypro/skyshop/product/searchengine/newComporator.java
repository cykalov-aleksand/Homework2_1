package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;

public class newComporator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (Integer.compare(o2.requestForSingleField().length(), o1.requestForSingleField().length()) != 0) {
            return Integer.compare(o2.requestForSingleField().length(), o1.requestForSingleField().length());
        } else {
            return o1.getSearchTemp().compareToIgnoreCase(o2.getSearchTemp());
        }
    }
}

