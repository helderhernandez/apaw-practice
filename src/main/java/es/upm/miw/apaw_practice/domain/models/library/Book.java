package es.upm.miw.apaw_practice.domain.models.library;

import java.math.BigDecimal;

public class Book {
    private String id;
    private String title;
    private BigDecimal price;
    private String ISBN;
    private String author;
    private boolean recommend;

    public  Book(){
        //empty from framework
    }
    public Book(String id, String title, BigDecimal price, String ISBN, String author, boolean recommend) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.ISBN = ISBN;
        this.author = author;
        this.recommend = recommend;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isRecommend() {
        return recommend;
    }

    public void setRecommend(boolean recommend) {
        this.recommend = recommend;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", ISBN='" + ISBN + '\'' +
                ", author='" + author + '\'' +
                ", recommend=" + recommend +
                '}';
    }
}
