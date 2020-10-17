package es.upm.miw.apaw_practice.adapters.rest.videogame;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.videogame.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(GamePlayerResource.GAMEPLAYERS)
public class GamePlayerResource {

    static final String GAMEPLAYERS = "/videogame/gameplayers";
    static final String ID = "/{id}";
    static final String SEARCH = "/search";

    private GamePlayerService gamePlayerService;

    @Autowired
    public GamePlayerResource(GamePlayerService gamePlayerService) {
        this.gamePlayerService = gamePlayerService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        gamePlayerService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<NickNameDto> findNickNameByGameDeveloper(@RequestParam String q){
        String name = new LexicalAnalyzer().extractWithAssure(q,"name");
        return this.gamePlayerService.findNickNameByGameDeveloper(name)
                .map(NickNameDto::new);
    }
}
