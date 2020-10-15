package es.upm.miw.apaw_practice.adapters.rest.library;

import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import es.upm.miw.apaw_practice.domain.services.library.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(LibrarianResource.LIBRARIAN)
public class LibrarianResource {
    static final String LIBRARIAN="/library/librarian";
    static final String ID_ID="/{id}";
    static final String NAME="/name";

    private final LibrarianService librarianService;

    @Autowired
    public LibrarianResource(LibrarianService librarianService) {
        this.librarianService = librarianService;
    }

    @PutMapping(ID_ID+NAME)
    public Librarian updateName(@PathVariable String id, @RequestBody NameDto nameDto){
        return this.librarianService.updateName(id,nameDto.getName());
    }


}
