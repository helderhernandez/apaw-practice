package es.upm.miw.apaw_practice.domain.persistence_ports.bank;

import es.upm.miw.apaw_practice.domain.models.bank.Account;

import java.math.BigDecimal;

public interface AccountPersistence {
    Account updateAmount(String id, BigDecimal amount);

    void deleteById(String id);
}
