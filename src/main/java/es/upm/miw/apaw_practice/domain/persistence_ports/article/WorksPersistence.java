package es.upm.miw.apaw_practice.domain.persistence_ports.article;

import java.math.BigDecimal;
import java.util.stream.Stream;

public interface WorksPersistence {
    void deleteById(String id);
    Stream<String> findAllIsmPriceMoreThanTen1(String name);
    BigDecimal findAllIsmPriceMoreThanTen(String name);
}
