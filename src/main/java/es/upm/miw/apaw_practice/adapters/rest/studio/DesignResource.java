package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.studio.Consumer;
import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import es.upm.miw.apaw_practice.domain.services.studio.DesignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(DesignResource.DESIGN)
public class DesignResource {

    static final String DESIGN = "/studio/designs";
    static final String SEARCH = "/search";
    static final String PHONE = "/phone";

    private DesignService designService;

    @Autowired
    public DesignResource(DesignService designService) {
        this.designService = designService;
    }

    @PostMapping
    public Design create(@RequestBody DesignCreation designCreation) {
        return this.designService.create(designCreation);
    }

    @GetMapping(SEARCH)
    public Stream<Consumer> findCustomersByType(@RequestParam String q) {
        String type = new LexicalAnalyzer()
                .extractWithAssure(q, "type");
        return this.designService.findCustomersByType(type);
    }

    @GetMapping(PHONE)
    public Stream<String> findDesignStylesByUserPhone(@RequestParam String q) {
        String phone = new LexicalAnalyzer()
                .extractWithAssure(q, "phone");
        return this.designService.findDesignStylesByUserPhone(phone);
    }
}
