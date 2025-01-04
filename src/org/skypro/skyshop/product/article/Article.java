package org.skypro.skyshop.product.article;

import org.skypro.skyshop.product.Searchable;

import java.util.Objects;

public class Article implements Searchable {
    private String titleAtribute;
    private String textAtribute;

    public Article(String titleAtribute, String textAtribute) {
        this.titleAtribute = titleAtribute;
        this.textAtribute = textAtribute;
    }


    @Override
    public String toString() {
        return (String.format("%22s%32s\n%22s%32s", "название статьи", titleAtribute, "текст статьи", textAtribute));
    }


    @Override
    public String getSearchTemp() {

        return String.format("%27s\n%27s", titleAtribute, textAtribute);
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Article article = (Article) object;
        return Objects.equals(titleAtribute, article.titleAtribute) && Objects.equals(textAtribute, article.textAtribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleAtribute, textAtribute);
    }
}
