package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.transport.Extra;
import es.upm.miw.apaw_practice.domain.models.transport.ExtraPaidUpdate;
import es.upm.miw.apaw_practice.domain.services.transport.ExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(ExtraResource.EXTRAS)
public class ExtraResource {
    static final String EXTRAS = "/transport/extras";
    static final String ID_ID = "/{id}";
    static final String SEARCH = "/search";


    private ExtraService extraService;

    @Autowired
    public ExtraResource(ExtraService extraService) {
        this.extraService = extraService;
    }

    @PatchMapping
    public void updateExtra(@RequestBody List<ExtraPaidUpdate> extraPaidUpdate) {
        this.extraService.updatePaid(extraPaidUpdate);
    }

    @GetMapping
    public Stream<Extra> readAll() {
        return this.extraService.readAll();
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.extraService.delete(id);
    }

    @GetMapping(SEARCH)
    public Stream<WorkedHoursExtraDto> readWorkedHoursByDepartment(@RequestParam String q) {
        String name = new LexicalAnalyzer().extractWithAssure(q, "name");
        return this.extraService.readWorkedHoursByDepartment(name)
                .map(WorkedHoursExtraDto::new);
    }

}
