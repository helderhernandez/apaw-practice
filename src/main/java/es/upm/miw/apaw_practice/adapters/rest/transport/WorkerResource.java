package es.upm.miw.apaw_practice.adapters.rest.transport;

import es.upm.miw.apaw_practice.domain.models.transport.Worker;
import es.upm.miw.apaw_practice.domain.services.transport.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WorkerResource.WORKERS)
public class WorkerResource {
    static final String WORKERS = "/transport/workers";
    static final String DNI_DNI = "/{dni}";

    private WorkerService workerService;

    @Autowired
    public WorkerResource(WorkerService workerService) {
        this.workerService = workerService;
    }

    @GetMapping(DNI_DNI)
    public Worker read(@PathVariable String dni) {
        return this.workerService.read(dni);
    }

}
