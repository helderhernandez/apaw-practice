package es.upm.miw.apaw_practice.adapters.rest.factory;

import es.upm.miw.apaw_practice.adapters.rest.LexicalAnalyzer;
import es.upm.miw.apaw_practice.domain.models.factory.Machine;
import es.upm.miw.apaw_practice.domain.services.factory.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MachineResource.MACHINES)
public class MachineResource {

    static final String MACHINES = "/factory/machines";
    static final String ID_ID = "/{id}";
    static final String STATUS = "/status";
    static final String SEARCH = "/search";

    private MachineService machineService;

    @Autowired
    public MachineResource(MachineService machineService) {
        this.machineService = machineService;
    }

    @PutMapping(ID_ID + STATUS)
    public Machine updateStatus(@PathVariable String id, @RequestBody StatusDto active) {
        return this.machineService.updateStatus(id, active.getActive());
    }

    @GetMapping(SEARCH)
    public List<Machine> findMachineByEmployeeDegreeTitle(@RequestBody String q) {
        String title = new LexicalAnalyzer().extractWithAssure(q, "title");
        return this.machineService.findMachineByEmployeeDegreeTitle(title);
    }

}
