package es.upm.miw.apaw_practice.adapters.mongodb.padel.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.padel.daos.PlayerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.padel.entities.PlayerEntity;
import es.upm.miw.apaw_practice.domain.exceptions.ConflictException;
import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.padel.PlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("playerPersistence")
public class PlayerPersistenceMongodb implements PlayerPersistence {
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerPersistenceMongodb(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player create(PlayerCreation playerCreation) {
        this.assertDniNotExist(playerCreation.getDni());
        return this.playerRepository
                .save(new PlayerEntity(playerCreation))
                .toPlayer();
    }

    public void assertDniNotExist(String dni) {
        this.playerRepository
                .findByDni(dni)
                .ifPresent(article -> {
                    throw new ConflictException("DNI exist: " + dni);
                });
    }
}
