package org.skypro.skyshop.product.searchengine;

import org.skypro.skyshop.exceptions.BestResultNotFound;
import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] searchable;

    public SearchEngine(int size) {
        this.searchable = new Searchable[size];
    }

    public Searchable[] getSearchable() {
        return searchable;
    }

    public Searchable[] search(String searchBar) {
        Searchable[] searchArray = new Searchable[5];
        int number = 0;
        for (Searchable element : searchable) {
            if ((element.getSearchTemp().toLowerCase().trim().contains(searchBar.toLowerCase().trim()))) {
                if (number < 5) {
                    searchArray[number] = element;
                    number++;
                } else {
                    break;
                }
            }
        }
        return searchArray;
    }

    public Searchable getSearchTerm(String search) throws BestResultNotFound {
        int indexStart = 0;
        int indexStop;
        int numberRepetitions = 0;
        int maximumNumberRepetitions = 0;
        Searchable maximumMatches = null;
        for (Searchable element : searchable) {
            if ((element.getSearchTemp().toLowerCase().trim().contains(search.toLowerCase().trim()))) {
                indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                while (indexStop != -1) {
                    numberRepetitions++;
                    indexStart = indexStop + search.length();
                    indexStop = element.getSearchTemp().toLowerCase().trim().indexOf(search.toLowerCase().trim(), indexStart);
                }
                if (numberRepetitions >= maximumNumberRepetitions) {
                    maximumNumberRepetitions = numberRepetitions;
                    maximumMatches = element;
                }
                indexStart = 0;
                numberRepetitions = 0;
            }
        }
        if (maximumMatches == null) {
            throw new BestResultNotFound(" ОБЪЕКТЫ ТИПА SEARCHABLE НЕ СОДЕРЖАТ СТРОКИ " + search.toUpperCase());
        }
        return maximumMatches;
    }

    public void add(Searchable[] newObject) {
        int numberEmptyCell = 0;
        for (int i = 0; i < searchable.length; i++) {
            if (searchable[i] == null) {
                numberEmptyCell = i;
                break;
            }
        }
        for (Searchable variable : newObject) {
            searchable[numberEmptyCell] = variable;
            numberEmptyCell++;
        }
    }
}
