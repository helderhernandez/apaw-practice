package es.upm.miw.apaw_practice.domain.services.property;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.ProprietorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ProprietorService {
    private final ProprietorPersistence proprietorPersistence;

    @Autowired
    public ProprietorService(ProprietorPersistence proprietorPersistence){
        this.proprietorPersistence = proprietorPersistence;
    }

    public Stream <Proprietor> readAll(){
        return this.proprietorPersistence.readAll();
    }

}
