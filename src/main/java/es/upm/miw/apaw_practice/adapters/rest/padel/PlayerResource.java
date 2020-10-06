package es.upm.miw.apaw_practice.adapters.rest.padel;

import es.upm.miw.apaw_practice.domain.models.padel.Player;
import es.upm.miw.apaw_practice.domain.models.padel.PlayerCreation;
import es.upm.miw.apaw_practice.domain.services.padel.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PlayerResource.PLAYERS)
public class PlayerResource {
    static final String PLAYERS ="/padel/players";

    private PlayerService playerService;

    @Autowired
    public PlayerResource(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player create(@RequestBody PlayerCreation playerCreation){
        return this.playerService.create(playerCreation);
    }
}
