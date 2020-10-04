package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.domain.models.school.Subject;
import es.upm.miw.apaw_practice.domain.services.school.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(SubjectResource.SUBJECTS)
public class SubjectResource {
    static final String SUBJECTS = "/school/subjects";

    static final String SEARCH = "/search";
    static final String ID_ID = "/{id}";
    static final String NAME = "/name";

    private final SubjectService subjectService;

    @Autowired
    public SubjectResource(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PutMapping(ID_ID + NAME)
    public Subject updateName(@PathVariable String id, @RequestBody NameDto nameDto) {
        return this.subjectService.updateName(id, nameDto.getName());
    }

    @GetMapping
    public Stream<Subject> readAll() {
        return this.subjectService.readAll();
    }
}
