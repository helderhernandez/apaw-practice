package es.upm.miw.apaw_practice.adapters.mongodb.library.entities;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BookEntity{
    @Id
    private String id;
    @Indexed(unique = true)
    private  String ISBN;
    private String title;
    private String author;
    private  Boolean state;

    public BookEntity(){
        //empty for framework
    }

    public BookEntity(String id, String title, String author, Boolean state, String ISBN) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.state = state;
        this.ISBN = ISBN;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void fromBook(Book book){
        BeanUtils.copyProperties(book,this);
    }
    public Book toBook(){
        Book book=new Book();
        BeanUtils.copyProperties(this, book);
        return book;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (ISBN.equals(((BookEntity) obj).ISBN));
    }

    @Override
    public int hashCode() {
        return ISBN.hashCode();
    }

    @Override
    public String toString() {
        return "BookEntity{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", state=" + state +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

}
