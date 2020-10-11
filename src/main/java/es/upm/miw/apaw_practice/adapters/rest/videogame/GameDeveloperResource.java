package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloper;
import es.upm.miw.apaw_practice.domain.models.videogame.GameDeveloperCreation;
import es.upm.miw.apaw_practice.domain.services.videogame.GameDeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(GameDeveloperResource.GDEVELOPERS)
public class GameDeveloperResource {

    static final String GDEVELOPERS = "/videogame/gdevelopers";
    static final String ID = "/{id}";
    static final String PHONE = "/phone";

    private GameDeveloperService gameDeveloperService;

    @Autowired
    public GameDeveloperResource(GameDeveloperService gameDeveloperService) {

        this.gameDeveloperService = gameDeveloperService;
    }

    @PostMapping
    public GameDeveloper create(@RequestBody GameDeveloperCreation gameDeveloperCreation) {
        return this.gameDeveloperService.create(gameDeveloperCreation);
    }

    @PutMapping(ID + PHONE)
    public GameDeveloper updatePhone(@PathVariable String id, @RequestBody PhoneDto phoneDto) {
        return this.gameDeveloperService.updatePhone(id, phoneDto.getPhone());
    }


}
