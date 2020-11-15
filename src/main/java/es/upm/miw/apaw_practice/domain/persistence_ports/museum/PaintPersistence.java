package es.upm.miw.apaw_practice.domain.persistence_ports.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import org.springframework.stereotype.Repository;

@Repository
public interface PaintPersistence {

    Paint create(Paint paint);

}
