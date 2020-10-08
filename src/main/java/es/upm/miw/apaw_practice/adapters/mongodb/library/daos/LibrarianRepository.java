package es.upm.miw.apaw_practice.adapters.mongodb.library.daos;


import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.LibrarianEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LibrarianRepository extends MongoRepository<LibrarianEntity,String> {

}
