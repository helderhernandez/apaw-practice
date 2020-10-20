package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibrarianPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class LibrarianService {
    private  final LibrarianPersistence librarianPersistence;

    @Autowired
    public LibrarianService(LibrarianPersistence librarianPersistence) {
        this.librarianPersistence = librarianPersistence;
    }
    public Librarian updateName(String id, String name){
        return this.librarianPersistence.updateName(id,name);
    }

    public Stream<Librarian> findPhoneByReaderDni(String dni) {
        return this.librarianPersistence.findPhoneByReaderDni(dni);
    }
}
