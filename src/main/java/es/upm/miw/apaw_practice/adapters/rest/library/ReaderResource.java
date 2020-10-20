package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import es.upm.miw.apaw_practice.domain.services.library.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(ReaderResource.READER)
public class ReaderResource {
    static final String READER="/library/reader";

    static final String SEARCH = "/search";
    private ReaderService readerService;

    @Autowired
    public ReaderResource(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public Reader create(@RequestBody ReaderCreation readerCreation){
        return this.readerService.create(readerCreation);
    }

    @GetMapping(SEARCH)
    public Stream<Reader> findNameByBookISBN(@RequestParam String q){
        String ISBN=new LexicalAnalyzer().extractWithAssure(q,"ISBN");
        return  this.readerService.findNameByBookISBN(ISBN);

    }
}
