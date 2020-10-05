package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.domain.models.sportcentre.Assistant;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import es.upm.miw.apaw_practice.domain.services.sportcentre.AssistantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping(AssistantResource.ASSISTANTS)
public class AssistantResource {

    static final String ASSISTANTS = "/sportcentre/assistants";
    static final String ID_ID = "/{id}";
    static final String PHONE = "/phone";

    private AssistantService assistantService;

    @Autowired
    public AssistantResource(AssistantService assistantService){
        this.assistantService = assistantService;
    }

    @PutMapping(ID_ID + PHONE)
    public Assistant updatePhone(@PathVariable String id, @RequestBody PhoneDto phoneDto){
        return this.assistantService.updatePhone(id, phoneDto.getPhone());
    }

}
