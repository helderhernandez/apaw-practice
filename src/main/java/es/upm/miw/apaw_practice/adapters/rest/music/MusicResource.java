package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.Music;
import es.upm.miw.apaw_practice.domain.services.music.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(MusicResource.MUSICS)
public class MusicResource {
    static final String MUSICS = "/music/musics";
    static final String SEARCH = "/search";
    static final String ID_ID = "{id}";
    static final String NAME = "/name";

    private final MusicService musicService;

    @Autowired
    public MusicResource(MusicService musicService) {
        this.musicService = musicService;
    }

    @PutMapping(ID_ID + NAME)
    public Music updateName(@PathVariable String id, @RequestBody NameDto nameDto) {
        return this.musicService.updateName(id, nameDto.getName());
    }
}