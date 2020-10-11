package es.upm.miw.apaw_practice.domain.persistence_ports.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.GamePlayer;

import java.util.stream.Stream;

public interface GamePlayerPersistence {
    Stream<GamePlayer> readAll();
}
