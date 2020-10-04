package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import es.upm.miw.apaw_practice.domain.services.sportcentre.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(InstructorResource.INSTRUCTORS)
public class InstructorResource {

    static final String INSTRUCTORS = "/sportcentre/instructors";

    private InstructorService instructorService;

    @Autowired
    public InstructorResource(InstructorService instructorService){
        this.instructorService = instructorService;
    }

    @PostMapping
    public Instructor create(@RequestBody InstructorCreation instructorCreation){
        return this.instructorService.create(instructorCreation);
    }

}
