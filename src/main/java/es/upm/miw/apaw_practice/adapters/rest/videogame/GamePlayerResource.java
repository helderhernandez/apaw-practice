package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.domain.services.videogame.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GamePlayerResource.GAMEPLAYERS)
public class GamePlayerResource {

    static final String GAMEPLAYERS = "/videogame/gameplayers";
    static final String ID = "/{id}";

    private GamePlayerService gamePlayerService;

    @Autowired
    public GamePlayerResource(GamePlayerService gamePlayerService) {
        this.gamePlayerService = gamePlayerService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        gamePlayerService.delete(id);
    }
}
