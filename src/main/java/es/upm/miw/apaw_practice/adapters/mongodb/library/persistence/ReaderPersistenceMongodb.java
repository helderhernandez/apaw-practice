package es.upm.miw.apaw_practice.adapters.mongodb.library.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.OrderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.daos.ReaderRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.library.entities.ReaderEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.library.Reader;
import es.upm.miw.apaw_practice.domain.persistence_ports.library.ReaderPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("readerPersistence")
public class ReaderPersistenceMongodb implements ReaderPersistence {

    private ReaderRepository readerRepository;
    private OrderRepository orderRepository;

    @Autowired
    public ReaderPersistenceMongodb(ReaderRepository readerRepository, OrderRepository orderRepository) {
        this.readerRepository = readerRepository;
        this.orderRepository = orderRepository;
    }

    public void assertDNI(String DNI){
        this.readerRepository
                .findByDNI(DNI)
                .ifPresent(reader->{
                    throw new ConflictException("DNI exist"+DNI);
                });
    }

    @Override
    public Reader create(Reader reader) {
        this.assertDNI(reader.getDNI());
        return this.readerRepository
                .save(new ReaderEntity(reader))
                .toReader();
    }

    @Override
    public Stream<Reader> findNameByISBN(String ISBN) {
        return NameByISBN(ISBN)
                .map(name->{
                    Reader a=new Reader();
                    a.setName(name);
                    return a;
                });
    }

    public  Stream<String> NameByISBN(String ISBN){
        return this.orderRepository.findAll().stream()
                .filter(orderEntity -> orderEntity.getBookEntity().getISBN().equals(ISBN))
                .map(orderEntity -> orderEntity.getReaderEntity().toReader().getName());
    }


}
