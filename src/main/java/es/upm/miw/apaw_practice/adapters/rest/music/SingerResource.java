package es.upm.miw.apaw_practice.adapters.rest.music;


import es.upm.miw.apaw_practice.domain.models.music.Singer;

import es.upm.miw.apaw_practice.domain.services.music.SingerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(SingerResource.SINGERS)
public class SingerResource {
    static final String SINGERS = "/music/singers";

    static final String SEARCH = "/search";

    public final SingerService singerService;

    @Autowired
    public SingerResource(SingerService singerService) {
        this.singerService = singerService;
    }

    @GetMapping
    public Stream<Singer> readAll(){
        return this.singerService.readAll();
    }

}