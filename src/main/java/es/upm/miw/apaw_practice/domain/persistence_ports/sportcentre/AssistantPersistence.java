package es.upm.miw.apaw_practice.domain.persistence_ports.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;

public interface AssistantPersistence {

    Assistant updatePhone(String id, int phone);
}
