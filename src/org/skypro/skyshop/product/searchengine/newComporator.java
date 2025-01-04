package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;

public class newComporator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable o1, Searchable o2) {
        if (o1.getSearchTemp().length() != o2.getSearchTemp().length()) {
            return Integer.compare(o2.getSearchTemp().length(), o1.getSearchTemp().length());
        } else {
            return o1.getSearchTemp().compareTo(o2.getSearchTemp());
        }
    }
}

