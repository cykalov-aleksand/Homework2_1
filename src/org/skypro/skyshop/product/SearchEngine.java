package org.skypro.skyshop.product;

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
