package es.upm.miw.apaw_practice.adapters.mongodb.videogame.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.daos.GamePlayerRepository;
import es.upm.miw.apaw_practice.domain.persistence_ports.videogame.GamePlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("GamePlayerPersistence")
public class GamePlayerPersistenceMongodb implements GamePlayerPersistence {

    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    public GamePlayerPersistenceMongodb(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }

    public void delete(String id){
        this.gamePlayerRepository.deleteById(id);
    }


}
