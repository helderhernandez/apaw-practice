package es.upm.miw.apaw_practice.domain.services.bank;


import es.upm.miw.apaw_practice.domain.models.bank.Account;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.AccountPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountPersistence accountPersistence;

    @Autowired
    public AccountService(AccountPersistence accountPersistence) {
        this.accountPersistence = accountPersistence;
    }

    public Account updateAmount(String id, BigDecimal amount) {
        return this.accountPersistence.updateAmount(id, amount);
    }
}
