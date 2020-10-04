package es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.persistance;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.daos.AssistantRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.AssistantEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre.AssistantPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("assistantPersistence")
public class AssistantPersistenceMongodb implements AssistantPersistence {

    private final AssistantRepository assistantRepository;

    @Autowired
    public AssistantPersistenceMongodb(AssistantRepository assistantRepository) {
        this.assistantRepository = assistantRepository;
    }

    @Override
    public Assistant updatePhone(String id, int phone) {
        AssistantEntity assistantEntity = this.assistantRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Assistant id: " + id));
        assistantEntity.setPhone(phone);
        return this.assistantRepository.save(assistantEntity).toAssistant();
    }

    @Override
    public Stream<Assistant> readAll() {
        return this.assistantRepository.findAll().stream()
                .map(assistantEntity -> assistantEntity.toAssistant());
    }
}
