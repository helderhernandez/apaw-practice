package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.EssayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.WorksRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity;
import es.upm.miw.apaw_practice.domain.models.article.Works;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.WorksPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.stream.Stream;

@Repository("worksPersistence")
public class WorksPersistenceMangodb implements WorksPersistence {
    private final WorksRepository worksRepository;
    private final EssayRepository essayRepository;

    @Autowired
    public WorksPersistenceMangodb(WorksRepository worksRepository,EssayRepository essayRepository) {this.worksRepository = worksRepository;
    this.essayRepository = essayRepository;}

    @Override
    public void deleteById(String id) { this.worksRepository.deleteById(id); }

    @Override
    public BigDecimal findAllIsmPriceMoreThanTen(String name){
        BigDecimal price = testFindAllIsmWorksByTypeName(name)
                .map(Works::getPrice)
                .reduce(BigDecimal::add)
                .orElse(new BigDecimal("0.00"));
        return price;
        }

        public Stream<Works> testFindAllIsmWorksByTypeName(String name){
            return this.worksRepository.findAll()
                    .stream()
                    .map(worksEntity -> worksEntity.toWorks())
                    .filter(works -> works.getEssayEntityList().stream()
                            .map(essayEntity -> essayEntity.getTypeEntity()
                                    .getName()).anyMatch(nameWorks -> nameWorks.equals(name)));

        }
    }