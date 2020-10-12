package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.Style;
import es.upm.miw.apaw_practice.domain.services.music.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(StyleResource.STYLES)
public class StyleResource {
    static final String STYLES = "/music/styles";

    static final String SEARCH = "/search";

    private final StyleService styleService;

    @Autowired
    public StyleResource(StyleService styleService){
        this.styleService = styleService;
    }

    @PostMapping
    public Style create(@RequestBody Style style){
        return this.styleService.create(style);
    }
}
