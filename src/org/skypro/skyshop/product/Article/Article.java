package org.skypro.skyshop.product.Article;

import org.skypro.skyshop.product.Searchable;

public class Article implements Searchable {
    private String titleAtribute;
    private String textAtribute;

    public Article(String titleAtribute, String textAtribute) {
        this.titleAtribute = titleAtribute;
        this.textAtribute = textAtribute;
    }


    @Override
    public String toString() {
        return (String.format("%20s",titleAtribute) + "\n" + String.format("%27s",textAtribute) );
    }


    @Override
    public String getSearchTemp() {
              return toString();
    }

    @Override
    public String getContentType() {
                return "ARTICLE";
         }
}
