package es.upm.miw.apaw_practice.adapters.mongodb.school.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SubjectPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("subjectPersistence")
public class SubjectPersistenceMongodb implements SubjectPersistence {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectPersistenceMongodb(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public Subject updateName(String id, String name) {
        SubjectEntity subjectEntity = this.subjectRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Subject id: " + id));
        subjectEntity.setName(name);
        return this.subjectRepository.save(subjectEntity).toSubject();
    }
}
