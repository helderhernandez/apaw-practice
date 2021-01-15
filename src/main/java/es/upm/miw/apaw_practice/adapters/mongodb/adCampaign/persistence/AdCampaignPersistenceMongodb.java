package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.persistence;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.AdCampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.CustomerTargetRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.AdCampaignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.domain.models.adCampaign.AdCampaign;
import es.upm.miw.apaw_practice.domain.persistence_ports.adCampaign.AdCampaignPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository("AdCampaignPersistence")
public class AdCampaignPersistenceMongodb implements AdCampaignPersistence {

    private AdCampaignRepository adCampaignRepository;

    private CustomerTargetRepository customerTargetRepository;

    @Autowired
    public AdCampaignPersistenceMongodb(AdCampaignRepository adCampaignRepository, CustomerTargetRepository customerTargetRepository) {
        this.adCampaignRepository = adCampaignRepository;
        this.customerTargetRepository = customerTargetRepository;
    }

    @Override
    public Stream<AdCampaign> readAll() {
        return adCampaignRepository.findAll().stream()
                .map(AdCampaignEntity::toAdCampaign);
    }


    @Override
    public Stream<String> findIdByLikesFromCustomerName(String name) {
        List<LikesEntity> likesEntityStream = this.customerTargetRepository.findAll()
                .stream()
                .filter(customerTargetEntity
                        -> (customerTargetEntity.getName().equals(name) && customerTargetEntity.getLikes() != null))
                .flatMap(customerTargetEntity -> customerTargetEntity.getLikes().stream())
                .collect(Collectors.toList());

        return this.adCampaignRepository
                .findAll()
                .stream()
                .filter(adCampaignEntity -> likesEntityStream.contains(adCampaignEntity.getLikesEntity()))
                .map(AdCampaignEntity::getId);
    }
}
