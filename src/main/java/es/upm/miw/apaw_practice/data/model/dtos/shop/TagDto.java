package es.upm.miw.apaw_practice.data.model.dtos.shop;

import es.upm.miw.apaw_practice.data.model.entities.shop.Article;
import es.upm.miw.apaw_practice.data.model.entities.shop.Tag;

import java.util.List;
import java.util.stream.Collectors;

public class TagDto {
    private String id;
    private String description;
    private List<Long> articlesBarcode;
    private Boolean favourite;

    public TagDto() {
        //empty for framework
    }

    public TagDto(Tag tag) {
        this.id = tag.getId();
        this.description = tag.getDescription();
        this.articlesBarcode = tag.getArticles().stream()
                .map(Article::getBarcode)
                .collect(Collectors.toList());
        this.favourite = tag.getFavourite();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getArticlesBarcode() {
        return articlesBarcode;
    }

    public void setArticlesBarcode(List<Long> articlesBarcode) {
        this.articlesBarcode = articlesBarcode;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public String toString() {
        return "TagDto{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", articlesBarcode=" + articlesBarcode +
                ", favourite=" + favourite +
                '}';
    }
}
