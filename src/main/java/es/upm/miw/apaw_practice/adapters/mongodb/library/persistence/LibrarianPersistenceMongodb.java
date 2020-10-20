package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.LibrarianRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibrarianEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.library.Librarian;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.LibrarianPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

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

    @Override
    public Stream<Librarian> findPhoneByReaderDni(String dni) {
        return PhoneByReaderDni(dni)
                .map(phone -> {
                    Librarian a = new Librarian();
                    a.setPhone(phone);
                    return a;
                });
    }

    public Stream<String> PhoneByReaderDni(String dni) {
        return this.librarianRepository.findAll().stream()
                .filter(librarianEntity -> librarianEntity.getOrderEntity().stream()
                        .anyMatch(orderEntity -> orderEntity.getReaderEntity().getDNI().equals(dni)))
                .map(librarianEntity->librarianEntity.toLibrarian().getPhone());
    }


}
