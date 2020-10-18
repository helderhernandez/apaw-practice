package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.ReaderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.ReaderEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.ReaderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("readerPersistence")
public class ReaderPersistenceMongodb implements ReaderPersistence {

    private ReaderRepository readerRepository;

    @Autowired
    public ReaderPersistenceMongodb(ReaderRepository readerRepository){
        this.readerRepository=readerRepository;
    }
    public void assertDNI(String DNI){
        this.readerRepository
                .findByDNI(DNI)
                .ifPresent(reader->{
                    throw new ConflictException("DNI exist"+DNI);
                });
    }

    @Override
    public Reader create(ReaderCreation readerCreation) {
        this.assertDNI(readerCreation.getDNI());
        return this.readerRepository
                .save(new ReaderEntity(readerCreation))
                .toReader();
    }
}
