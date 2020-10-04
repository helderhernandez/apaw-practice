package es.upm.miw.apaw_practice.domain.services.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.AssistantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class AssistantService {

    private final AssistantPersistence assistantPersistence;

    @Autowired
    public AssistantService(AssistantPersistence assistantPersistence) {
        this.assistantPersistence = assistantPersistence;
    }

    public Assistant updatePhone(String id, int phone) {
        return this.assistantPersistence.updatePhone(id, phone);
    }

    public Stream<Assistant> readAll() {
        return this.assistantPersistence.readAll();
    }
}
