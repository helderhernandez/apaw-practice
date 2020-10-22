package es.upm.miw.apaw_practice.domain.services.article;

import es.upm.miw.apaw_practice.domain.persistence_ports.article.WorksPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class WorksService {
    private final WorksPersistence worksPersistence;

    @Autowired
    public WorksService(WorksPersistence worksPersistence) { this.worksPersistence = worksPersistence; }

    public void delete(String id) { this.worksPersistence.deleteById(id); }

    public BigDecimal findAllIsmPriceMoreThanTen(String name){
        return this.worksPersistence.findAllIsmPriceMoreThanTen(name);
    }
}
