package es.upm.miw.apaw_practice.adapters.rest.videogame;


import es.upm.miw.apaw_practice.domain.models.videogame.Level;
import es.upm.miw.apaw_practice.domain.services.videogame.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(LevelResource.LEVELS)
public class LevelResource {
    static final String LEVELS = "/videogame/levels";

    private LevelService levelService;

    @Autowired
    public LevelResource(LevelService levelService) {
        this.levelService = levelService;
    }

    @GetMapping
    public Stream<Level> readAll() {
        return this.levelService.readAll();
    }

}
