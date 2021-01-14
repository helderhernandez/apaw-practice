package es.upm.miw.apaw_practice.adapters.rest.museum;

import es.upm.miw.apaw_practice.domain.models.museum.Paint;
import es.upm.miw.apaw_practice.domain.services.museum.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(PaintResource.PAINTS)
public class PaintResource {

    static final String PAINTS = "/musemum/paints";
    static final String ID_ID = "/{id}";

    private PaintService paintService;

    @Autowired
    public PaintResource(PaintService paintService) {
        this.paintService = paintService;
    }

    @PostMapping
    public Paint create(@RequestBody Paint paint){
        return this.paintService.create(paint);
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.paintService.delete(id);
    }





}
