package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GameDeveloperRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GameDeveloperPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("gameDeveloperPersistence")
public class GameDeveloperPersistenceMongodb implements GameDeveloperPersistence {

    private GameDeveloperRepository gameDeveloperRepository;

    @Autowired
    public GameDeveloperPersistenceMongodb(GameDeveloperRepository gameDeveloperRepository) {
        this.gameDeveloperRepository = gameDeveloperRepository;
    }

    @Override
    public GameDeveloper create(GameDeveloperCreation gameDeveloperCreation) {

        this.assertNameNotExist(gameDeveloperCreation.getName());
        return this.gameDeveloperRepository
                .save(new GameDeveloperEntity(gameDeveloperCreation))
                .toGameDeveloper();
    }

    @Override
    public GameDeveloper updatePhone(String id, Integer phone) {
        GameDeveloperEntity gameDeveloperEntity = this.gameDeveloperRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("GameDeveloper id: " + id));
        gameDeveloperEntity.setPhone(phone);
        return this.gameDeveloperRepository.save(gameDeveloperEntity).toGameDeveloper();
    }

    public void assertNameNotExist(String name) {
        this.gameDeveloperRepository
                .findByName(name)
                .ifPresent(gameDeveloper -> {
                    throw new ConflictException("Name exist: " + gameDeveloper);
                });
    }


}
