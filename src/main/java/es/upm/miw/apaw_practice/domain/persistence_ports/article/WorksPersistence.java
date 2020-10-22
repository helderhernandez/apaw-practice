package es.upm.miw.apaw_practice.domain.persistence_ports.article;

import java.math.BigDecimal;

public interface WorksPersistence {
    void deleteById(String id);
    BigDecimal findAllIsmPriceMoreThanTen(String name);
}
