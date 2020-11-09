package es.upm.miw.apaw_practice.adapters.rest.museum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(PaintResource.PAINTS)
public class PaintResource {

    static final String PAINTS = "/musemum/paints";

    private PaintService paintService;

    @Autowired
    public PaintResource(PaintService paintService) {
        this.paintService = paintService;
    }


}
