package es.upm.miw.apaw_practice.adapters.rest.music;

import es.upm.miw.apaw_practice.domain.models.music.Style;
import es.upm.miw.apaw_practice.domain.models.music.StyleDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.services.music.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(StyleResource.STYLES)
public class StyleResource {
    static final String STYLES = "/music/styles";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";

    private final StyleService styleService;

    @Autowired
    public StyleResource(StyleService styleService){
        this.styleService = styleService;
    }

    @PostMapping
    public Style create(@RequestBody Style style){
        return this.styleService.create(style);
    }

    @PatchMapping
    public void updateStyles(@RequestBody List<StyleDescriptionUpdating> styleDescriptionUpdatingList){
        this.styleService.updateDescription(styleDescriptionUpdatingList);
    }
}
