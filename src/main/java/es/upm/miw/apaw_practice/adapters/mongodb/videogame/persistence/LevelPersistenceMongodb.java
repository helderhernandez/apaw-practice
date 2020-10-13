package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;


import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.LevelRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.ChallengeEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GamePlayerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.LevelEntity;
import es.upm.miw.apaw_practice.domain.models.videogame.Challenge;
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

    @Override
    public Stream<Challenge> findCompletedChallengesByDescription(String description) {
        return this.levelRepository.findAll()
                .stream()
                .filter(levelEntity -> levelEntity.getDescription().equals(description))
                .flatMap(levelEntity -> levelEntity.getGamePlayerEntities().stream())
                .filter(gamePlayerEntity -> gamePlayerEntity.getChallengeEntities()
                        .stream()
                        .anyMatch(challengeEntity -> challengeEntity.getCompleted() == true))
                .flatMap(challengeEntity -> challengeEntity.getChallengeEntities().stream())
                .map(ChallengeEntity::toChallenge);

    }
}
