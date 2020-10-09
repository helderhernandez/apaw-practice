package es.upm.miw.apaw_practice.adapters.rest.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Account;
import es.upm.miw.apaw_practice.domain.services.bank.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(AccountResource.ACCOUNTS)
public class AccountResource {

    static final String ACCOUNTS = "/bank/accounts";
    static final String ID_ID = "/{id}";
    static final String AMOUNT = "/amount";

    private final AccountService accountService;

    @Autowired
    public AccountResource(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping(ID_ID + AMOUNT)
    public Account updateAmount(@PathVariable String id, @RequestBody BigDecimalDto amount) {
        return this.accountService.updateAmount(id, amount.getAmount());
    }

    @DeleteMapping(ID_ID)
    public void delete(@PathVariable String id) {
        this.accountService.delete(id);
    }
}
