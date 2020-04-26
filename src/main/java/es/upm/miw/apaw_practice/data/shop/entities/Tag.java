package es.upm.miw.apaw_practice.data.shop.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Document
public class Tag {
    @Id
    private String id;
    @Indexed(unique = true)
    private String description;
    @DBRef
    private List<Article> articles;
    private Boolean favourite;

    public Tag() {
        this.id = UUID.randomUUID().toString();
    }

    public Tag(String description, List<Article> articles, Boolean favourite) {
        this.description = description;
        this.articles = articles;
        this.favourite = favourite;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    @Override
    public int hashCode() {
        return this.description.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (description.equals(((Tag) obj).description));
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", articles=" + articles +
                ", favourite=" + favourite +
                '}';
    }
}
