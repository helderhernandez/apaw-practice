package es.upm.miw.apaw_practice.domain.services.studio;

import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import es.upm.miw.apaw_practice.domain.models.studio.Consumer;
import es.upm.miw.apaw_practice.domain.models.studio.Design;
import es.upm.miw.apaw_practice.domain.models.studio.DesignCreation;
import es.upm.miw.apaw_practice.domain.persistence_ports.studio.DesignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DesignService {

    private final DesignPersistence designPersistence;

    @Autowired
    public DesignService(DesignPersistence designPersistence) {
        this.designPersistence = designPersistence;
    }

    public Design create(DesignCreation designCreation) {
        return this.designPersistence.create(designCreation);
    }

    public Stream<Consumer> findCustomersByType(String type) {
        return this.designPersistence.findConsumersByTypeDesign(type);
    }

    public Stream<String> findDesignStylesByUserPhone(String phone) {
        return this.designPersistence.findDesignStylesByUserPhone(phone);
    }
}
