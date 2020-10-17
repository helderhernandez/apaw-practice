package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.models.library.ReaderCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.ReaderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReaderService {
    private ReaderPersistence readerPersistence;

    @Autowired
    public ReaderService(ReaderPersistence readerPersistence) {
        this.readerPersistence = readerPersistence;
    }
    public Reader create(ReaderCreation readerCreation){
        return this.readerPersistence.create(readerCreation);
    }
}
