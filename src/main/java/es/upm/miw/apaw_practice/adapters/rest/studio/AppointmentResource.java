package es.upm.miw.apaw_practice.adapters.rest.studio;

import es.upm.miw.apaw_practice.domain.services.studio.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(AppointmentResource.APPOINTMENT)
public class AppointmentResource {

    static final String APPOINTMENT = "/studio/appointments";
    static final String ID = "/{id}";

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentResource(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable String id) {
        this.appointmentService.delete(id);
    }
}
