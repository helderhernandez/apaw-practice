package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.EssayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.EssayEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.article.Essay;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.EssayPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("essayPersistence")
public class EssayPersistenceMangodb implements EssayPersistence {

    private final EssayRepository essayRepository;


    @Autowired
    public EssayPersistenceMangodb(EssayRepository essayRepository) { this.essayRepository = essayRepository; }

    @Override
    public Essay updateName(String id,String name){
        EssayEntity essayEntity = this.essayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Essay id:" + id));
        essayEntity.setName(name);
        return this.essayRepository.save(essayEntity).toEssay();
    }
}
