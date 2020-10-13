package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.CustomerTargetEntity;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerTargetRepository extends MongoRepository<CustomerTargetEntity, String> {
}
