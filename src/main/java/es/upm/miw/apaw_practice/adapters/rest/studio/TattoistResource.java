package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.domain.services.studio.TattoistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(TattoistResource.TATTOIST)
public class TattoistResource {

    static final String TATTOIST = "/studio/tattoists";

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
}
