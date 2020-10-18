package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import es.upm.miw.apaw_practice.domain.services.library.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ReaderResource.READER)
public class ReaderResource {
    static final String READER="/library/reader";

    private ReaderService readerService;

    @Autowired
    public ReaderResource(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public Reader create(@RequestBody ReaderCreation readerCreation){
        return this.readerService.create(readerCreation);
    }
}
