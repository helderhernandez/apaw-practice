package es.upm.miw.apaw_practice.adapters.mongodb.school.daos;

import es.upm.miw.apaw_practice.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestConfig
class SubjectEntityRepositoryIT {

    @Autowired
    private SubjectRepository subjectRepository;

    @Test
    void testCreateAndRead() {
        assertTrue(this.subjectRepository.findAll().stream()
                .anyMatch(subj ->
                        "Maths".equals(subj.getName()) &&
                                "Science".equals(subj.getKnowledgeArea()) &&
                                subj.getId() != null &&
                                subj.getCreationDate() != null &&
                                subj.getCreationDate().isBefore(LocalDateTime.now()) &&
                                "33667788R".equals(subj.getTeacherEntity().getDni())
                ));
    }
}
