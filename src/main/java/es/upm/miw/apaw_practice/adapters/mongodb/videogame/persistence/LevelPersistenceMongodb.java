package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.LevelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.LevelEntity;
import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.LevelPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository("levelPersistence")
public class LevelPersistenceMongodb implements LevelPersistence {

    private LevelRepository levelRepository;

    @Autowired
    public LevelPersistenceMongodb(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Override
    public Stream<Level> readAll() {
        return levelRepository.findAll().stream()
                .map(LevelEntity::toLevel);
    }
}
