package es.upm.miw.apaw_practice.domain.services.property;

import es.upm.miw.apaw_practice.domain.models.property.Proprietor;
import es.upm.miw.apaw_practice.domain.models.property.ProprietorEmailUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.property.ProprietorPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public void updateEmail(List<ProprietorEmailUpdating> proprietorEmailUpdatingList) {
        proprietorEmailUpdatingList.stream()
                .map(proprietorNewEmail -> {
                    Proprietor proprietor = this.proprietorPersistence.readByDni(proprietorNewEmail.getDni());
                    proprietor.setEmail(proprietorNewEmail.getEmail());
                    return proprietor;
                })
                .forEach(student -> this.proprietorPersistence.update(student));
    }

}
