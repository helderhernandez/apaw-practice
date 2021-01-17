package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface PaintPersistence {

    Paint create(Paint paint);

    void deleteById(String id);

    Stream<Paint> findPaintCollectionByArtRestorerSurname(String artRestorerSurname);

}
