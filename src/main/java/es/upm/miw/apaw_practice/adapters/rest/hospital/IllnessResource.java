package es.upm.miw.apaw_practice.adapters.rest.hospital;

import es.upm.miw.apaw_practice.domain.models.hospital.IllnessContagiousUpdating;
import es.upm.miw.apaw_practice.domain.services.hospital.IllnessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(IllnessResource.ILLNESES)
public class IllnessResource {
    static final String ILLNESES = "/hospital/illneses";

    private IllnessService illnessService;

    @Autowired
    public IllnessResource(IllnessService illnessService) {
        this.illnessService = illnessService;
    }

    @GetMapping
    public Stream<BasicIllnessDto> readAll() {
        return this.illnessService.readAll().map(BasicIllnessDto::new);
    }

    @PatchMapping
    public void updateContagious(@RequestBody IllnessContagiousUpdating illnessContagiousUpdating) {
        this.illnessService.updateContagious(illnessContagiousUpdating);
    }
}
