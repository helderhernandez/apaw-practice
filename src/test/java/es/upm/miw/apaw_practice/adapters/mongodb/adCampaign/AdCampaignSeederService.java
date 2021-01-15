package es.upm.miw.apaw_practice.adapters.mongodb.adCampaign;

import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.AdCampaignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.CustomerTargetRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.LikesRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.daos.PromotionRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.AdCampaignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.CustomerTargetEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.LikesEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.adCampaign.entities.PromotionEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.bank.entities.CustomerEntity;
import es.upm.miw.apaw_practice.domain.models.bank.Customer;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AdCampaignSeederService {

    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private PromotionRepository promotionRepository;
    @Autowired
    private CustomerTargetRepository customerTargetRepository;
    @Autowired
    private AdCampaignRepository adCampaignRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- AdCampaign Initial Load -----------");

        LikesEntity[] likes = {
                new LikesEntity("likes-01", "Artes", "Pintura, lienzos, pinceles"),
                new LikesEntity("likes-02", "Artes Marciales", "Taekwondo, Karate, MMA"),
                new LikesEntity("likes-03", "Montaña", "Trail running, MTB"),
                new LikesEntity("likes-04", "Paisaje", "Cuadros de nevados"),
                new LikesEntity("likes-05", "Puzzle", "Puzzles 2d n piezas, cubo rubik")
        };
        this.likesRepository.saveAll(Arrays.asList(likes));

        PromotionEntity[] promotions = {
                new PromotionEntity("promotion-01", "agosto2020", "Descuento por el mes del arte",
                        "Descuento de 30% en pinceles y lienzos"),
                new PromotionEntity("promotion-02", "diciembre2020", "Renueva la navidad",
                        "Descuento 5* en figurillas navideñas"),
                new PromotionEntity("promotion-03", "enero2020", "Inicia con el pie derecho",
                        "Hasta el 20% de descuento en laptops")

        };
        this.promotionRepository.saveAll(Arrays.asList(promotions));

        CustomerTargetEntity[] customerTargets = {
                new CustomerTargetEntity("customer-01", "Tomas", "Unda",
                        "tmunda@gmail.com", true, List.of(likes[0], likes[1], likes[4])),
                new CustomerTargetEntity("customer-02", "Valentina", "Cruz",
                        "vacruz@gmail.com", true, List.of(likes[3], likes[4])),
                new CustomerTargetEntity("customer-03", "David", "Amaya",
                        "daxamayac@gmail.com", true, null),
        };
        this.customerTargetRepository.saveAll(Arrays.asList(customerTargets));

        AdCampaignEntity[] adCampaigns = {
                new AdCampaignEntity("adCampaign-01", LocalDateTime.of(2020,9,1,13,0,0),
                        likes[0], List.of(promotions[0])),
                new AdCampaignEntity("adCampaign-02", LocalDateTime.of(2020,12,1,13,0,0),
                        likes[0], List.of(promotions[0],promotions[2])),
                new AdCampaignEntity("adCampaign-03", LocalDateTime.of(2021,1,1,13,0,0),
                        likes[2], List.of(promotions[2],promotions[0]))
        };
        this.adCampaignRepository.saveAll(Arrays.asList(adCampaigns));
    }

    public void deleteAll() {
        this.likesRepository.deleteAll();
        this.customerTargetRepository.deleteAll();
        this.promotionRepository.deleteAll();
        this.adCampaignRepository.deleteAll();
    }
}
