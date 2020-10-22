package es.upm.miw.apaw_practice.domain.services.library;

import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.ReaderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ReaderService {
    private ReaderPersistence readerPersistence;

    @Autowired
    public ReaderService(ReaderPersistence readerPersistence) {
        this.readerPersistence = readerPersistence;
    }
    public Reader create(Reader reader){
        return this.readerPersistence.create(reader);
    }
    public Stream<Reader> findNameByBookISBN(String ISBN){
        return this.readerPersistence.findNameByISBN(ISBN);
    }
}
