package es.upm.miw.apaw_practice.domain.persistence_ports.project;

import es.upm.miw.apaw_practice.domain.models.project.Label;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelPersistence {

    Label create(Label label);

}
