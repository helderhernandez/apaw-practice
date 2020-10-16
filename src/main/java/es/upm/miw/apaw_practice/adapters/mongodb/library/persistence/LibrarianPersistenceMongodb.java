package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibrarianRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibrarianEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibrarianPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("librarianPersistence")
public class LibrarianPersistenceMongodb implements LibrarianPersistence {

    private final LibrarianRepository librarianRepository;

    @Autowired
    public LibrarianPersistenceMongodb(LibrarianRepository librarianRepository) {
        this.librarianRepository = librarianRepository;
    }

    @Override
    public Librarian updateName(String id, String name) {
        LibrarianEntity librarianEntity=this.librarianRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Librarian id"+id));
        librarianEntity.setName(name);
        return this.librarianRepository.save(librarianEntity).toLibrarian();
    }
}
