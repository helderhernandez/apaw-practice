package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import es.upm.miw.apaw_practice.domain.services.videogame.GameDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GameDeveloperResource.GDEVELOPERS)
public class GameDeveloperResource {

    static final String GDEVELOPERS = "/videogame/gdevelopers";

    private GameDeveloperService gameDeveloperService;

    @Autowired
    public GameDeveloperResource(GameDeveloperService gameDeveloperService) {

        this.gameDeveloperService = gameDeveloperService;
    }

    @PostMapping
    public GameDeveloper create(@RequestBody GameDeveloperCreation gameDeveloperCreation) {
        return this.gameDeveloperService.create(gameDeveloperCreation);
    }



}
