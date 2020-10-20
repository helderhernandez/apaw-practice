package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.domain.models.article.Type;
import es.upm.miw.apaw_practice.domain.models.article.TypeDescriptionUpdating;
import es.upm.miw.apaw_practice.domain.services.article.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(TypeResource.TYPES)
public class TypeResource {
    static  final String TYPES = "/article/types";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";

    private final TypeService typeService;

    @Autowired
    public TypeResource(TypeService typeService) { this.typeService = typeService; }

    @PostMapping
    public Type create(@RequestBody Type type) { return  this.typeService.creat(type); }

    @PatchMapping
    public void updateTypes(@RequestBody List<TypeDescriptionUpdating> typeDescriptionUpdatingList){
        this.typeService.updateDescription(typeDescriptionUpdatingList);
    }
}
