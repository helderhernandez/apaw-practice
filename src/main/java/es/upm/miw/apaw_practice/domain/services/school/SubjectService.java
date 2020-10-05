package es.upm.miw.apaw_practice.domain.services.school;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.persistence_ports.school.SubjectPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class SubjectService {
    private final SubjectPersistence subjectPersistence;

    @Autowired
    public SubjectService(SubjectPersistence subjectPersistence) {
        this.subjectPersistence = subjectPersistence;
    }

    public Subject updateName(String id, String name) {
        return this.subjectPersistence.updateName(id, name);
    }
}
