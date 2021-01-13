package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import es.upm.miw.apaw_practice.domain.services.studio.TattoistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(TattoistResource.TATTOIST)
public class TattoistResource {

    static final String TATTOIST = "/studio/tattoists";
    static final String ID = "/{id}";
    static final String NICKNAME = "/nickname";

    private TattoistService tattoistService;

    @Autowired
    public TattoistResource(TattoistService tattoistService) {
        this.tattoistService = tattoistService;
    }

    @GetMapping
    public Stream<BasicTattoistDto> readAll() {
        return this.tattoistService
                .readAll()
                .map(BasicTattoistDto::new);
    }

    @PutMapping(ID + NICKNAME)
    public Tattoist updateNickname(@PathVariable String id, @RequestBody String nickname) {
       return this.tattoistService.updateNickname(id, nickname);
    }
}
