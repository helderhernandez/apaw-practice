package es.upm.miw.apaw_practice.domain.persistence_ports.article;

import es.upm.miw.apaw_practice.domain.models.article.Essay;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;


@Repository
public interface EssayPersistence {
    Essay updateName(String id,String name);
    Stream<Essay> findEssayIdByAuthor(String nationality);
}
