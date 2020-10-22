package es.upm.miw.apaw_practice.adapters.mongodb.article.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.EssayRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.daos.WorksRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.article.entities.EssayEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.article.Essay;
import es.upm.miw.apaw_practice.domain.persistence_ports.article.EssayPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("essayPersistence")
public class EssayPersistenceMangodb implements EssayPersistence {

    private final EssayRepository essayRepository;
    private final WorksRepository worksRepository;


    @Autowired
    public EssayPersistenceMangodb(EssayRepository essayRepository, WorksRepository worksRepository){
        this.essayRepository = essayRepository;
        this.worksRepository = worksRepository;
    }

    @Override
    public Essay updateName(String id,String name){
        EssayEntity essayEntity = this.essayRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Essay id:" + id));
        essayEntity.setName(name);
        return this.essayRepository.save(essayEntity).toEssay();
    }

    @Override
    public Stream<Essay> findEssayIdByAuthor(String nationality){
        return this.worksRepository.findAll().stream()
                .map(worksEntity -> worksEntity.toWorks())
                .filter(works -> works.getAuthorEntityList().stream()
                        .anyMatch(authorEntity -> authorEntity.getNationality().equals(nationality)))
                .map(works -> works.getEssayEntityList())
                .flatMap(essayEntities -> essayEntities.stream())
                .map(essayEntity -> essayEntity.toEssay());
    }
}
