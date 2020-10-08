package es.upm.miw.apaw_practice.domain.services.garage;

import es.upm.miw.apaw_practice.domain.models.garage.Mechanic;
import es.upm.miw.apaw_practice.domain.persistence_ports.garage.MechanicPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class MechanicService {

    private MechanicPersistence mechanicPersistence;

    @Autowired
    public MechanicService(MechanicPersistence mechanicPersistence){
        this.mechanicPersistence = mechanicPersistence;
    }

    public Stream<Mechanic> readAll() {
        return this.mechanicPersistence.readAll();
    }

}
