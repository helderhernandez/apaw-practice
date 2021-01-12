package es.upm.miw.apaw_practice.adapters.rest.adCampaign;

import es.upm.miw.apaw_practice.domain.models.adCampaign.CustomerTarget;
import es.upm.miw.apaw_practice.domain.services.adCampaign.CustomerTargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerTargetResource.CUSTOMER_TARGET)
public class CustomerTargetResource {

    static final String CUSTOMER_TARGET = "/ad-campaign/customer-targets";
    static final String ID_ID = "/{id}";
    static final String NAME = "/name";

    private CustomerTargetService customerTargetService;

    @Autowired
    public CustomerTargetResource(CustomerTargetService customerTargetService) {
        this.customerTargetService = customerTargetService;
    }

    @PutMapping(ID_ID + NAME)
    public CustomerTarget updateDescription(@PathVariable String id, @RequestBody NameDto nameDto) {
        return this.customerTargetService.updateName(id, nameDto.getName());
    }
}
