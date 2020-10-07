package es.upm.miw.apaw_practice.adapters.rest.bank;

import es.upm.miw.apaw_practice.domain.services.bank.ShareholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(ShareholderResource.SHAREHOLDERS)
public class ShareholderResource {

    static final String SHAREHOLDERS = "/bank/shareholders";

    private final ShareholderService shareholderService;

    @Autowired
    public ShareholderResource(ShareholderService shareholderService) {
        this.shareholderService = shareholderService;
    }

    @PatchMapping
    public void updateExpirationDates(LocalDateTime localDateTime) {
        this.shareholderService.updateExpirationDates(localDateTime);
    }
}
