package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.BookRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.BookEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.BookPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("bookPersistence")
public class BookPersistenceMongodb implements BookPersistence {

    private BookRepository bookRepository;

    @Autowired
    public BookPersistenceMongodb(BookRepository bookRepository){
        this.bookRepository=bookRepository;
    }

    public Book updateBookPrice(Book book){
        BookEntity bookEntity=this.bookRepository
                .findByISBN(book.getISBN())
                .orElseThrow(()->new NotFoundException("Book id"+book.getISBN()));
        bookEntity.fromBook(book);
        return  this.bookRepository
                .save(bookEntity)
                .toBook();
    }
    public Book readByISBN(String ISBN){
        return this.bookRepository
                .findByISBN(ISBN)
                .orElseThrow(()->new NotFoundException("ISBN:"+ISBN))
                .toBook();

    }
    public void deleteByISBN(String ISBN){
        this.bookRepository.deleteById(ISBN);
    }
}
