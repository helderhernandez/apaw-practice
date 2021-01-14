package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.services.studio.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(AppointmentResource.APPOINTMENT)
public class AppointmentResource {

    static final String APPOINTMENT = "/studio/appointments";
    static final String ID = "/{id}";
    static final String SEARCH = "/search";

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        this.appointmentService.delete(id);
    }

    @PatchMapping
    public void updateIsActiveFlags(Boolean isActive) {
        this.appointmentService.updateIsActiveFlags(isActive);
    }

    @GetMapping(SEARCH)
    public void getIdsAppointmentByTattoistName(@RequestParam String q) {
        String name = new LexicalAnalyzer()
                .extractWithAssure(q, "name");
        this.appointmentService.getIdsAppointmentByTattoistName(name);
    }
}
