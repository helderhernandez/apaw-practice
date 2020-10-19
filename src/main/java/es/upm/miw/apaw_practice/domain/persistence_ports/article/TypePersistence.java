package es.upm.miw.apaw_practice.domain.persistence_ports.article;

import es.upm.miw.apaw_practice.domain.models.article.Type;

public interface TypePersistence {
    Type create(Type type);
    Type update(Type type);
    Type readByName(String name);
}
