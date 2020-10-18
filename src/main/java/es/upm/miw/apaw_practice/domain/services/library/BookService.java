package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Book;
import es.upm.miw.apaw_practice.domain.models.library.BookPriceUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.BookPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookPersistence bookPersistence;

    @Autowired
    public BookService(BookPersistence bookPersistence){
        this.bookPersistence=bookPersistence;
    }

    public void updateBookPrice(List<BookPriceUpdating> bookPriceUpdatingList){
        bookPriceUpdatingList.stream()
                .map(BookNewPrice ->{
                    Book book=this.bookPersistence.readByISBN(BookNewPrice.getISBN());
                    book.setPrice(BookNewPrice.getPrice());
                    return book;
                })
                .forEach(book -> this.bookPersistence.updateBookPrice(book));
    }
    public void delete(String ISBN){
        this.bookPersistence.deleteByISBN(ISBN);
    }
}
