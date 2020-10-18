package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.BookPriceUpdating;
import es.upm.miw.apaw_practice.domain.services.library.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(BookResource.BOOK)
public class BookResource {
    static final String BOOK="/library/book";

    static final String ISBN_ISBN = "/{ISBN}";

    private BookService bookService;

    @Autowired
    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @PatchMapping
    public void updateBookPrice(@RequestBody List<BookPriceUpdating> bookPriceUpdatingList){
        this.bookService.updateBookPrice(bookPriceUpdatingList);
    }

    @DeleteMapping(ISBN_ISBN)
    public void delete(@PathVariable String ISBN){
        this.bookService.delete(ISBN);
    }
}
