package es.upm.miw.apaw_practice.adapters.mongodb.bank.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.bank.daos.AccountRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.AccountEntity;
import es.upm.miw.apaw_practice.domain.exceptions.NotFoundException;
import es.upm.miw.apaw_practice.domain.models.bank.Account;
import es.upm.miw.apaw_practice.domain.persistence_ports.bank.AccountPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository("accountPersistence")
public class AccountPersistenceMongodb implements AccountPersistence {

    private final AccountRepository accountRepository;

    private final CustomerPersistenceMongodb customerPersistence;

    @Autowired
    public AccountPersistenceMongodb(AccountRepository accountRepository,
                                     CustomerPersistenceMongodb customerPersistence) {
        this.accountRepository = accountRepository;
        this.customerPersistence = customerPersistence;
    }

    @Override
    public Account updateAmount(String id, BigDecimal amount) {
        AccountEntity accountEntity = this.accountRepository
                .findById(id)
                .orElseThrow(() -> new NotFoundException("Account id: " + id));
        accountEntity.setAmount(amount);
        return this.accountRepository
                .save(accountEntity)
                .toAccount();
    }

    public void deleteById(String id) {
        this.accountRepository.deleteById(id);
    }

    public List<String> findIdByCustomerWithShareholderWithValueGreaterThan(BigDecimal value) {

        return null; //TODO

        /*
        return this.customerPersistence.findCustomerByShareholderWithValueGreaterThan(value).stream()
                .map(customer -> this.accountRepository.findAll().stream()
                .flatMap(accountEntity -> accountEntity.getIdByCustomer(customer))).collect(Collectors.toList());  */

    }
}
