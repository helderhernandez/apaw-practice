package es.upm.miw.apaw_practice.domain.services.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.Illness;
import es.upm.miw.apaw_practice.domain.models.hospital.IllnessContagiousUpdating;
import es.upm.miw.apaw_practice.domain.persistence_ports.hospital.IllnessPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class IllnessService {
    private IllnessPersistence illnessPersistence;

    @Autowired
    public IllnessService(IllnessPersistence illnessPersistence){
        this.illnessPersistence=illnessPersistence;
    }

    public Stream<Illness> readAll(){
        return this.illnessPersistence.readAll();
    }

    public void updateContagious(IllnessContagiousUpdating illnessContagiousUpdating) {
            this.illnessPersistence.readByPhase(illnessContagiousUpdating.getPhase())
                    .peek(illness -> illness.setContagious(illnessContagiousUpdating.getContagious()))
                    .forEach(illness -> this.illnessPersistence.update(illness));
    }
}
