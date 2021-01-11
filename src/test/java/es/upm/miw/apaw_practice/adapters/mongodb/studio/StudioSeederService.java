package es.upm.miw.apaw_practice.adapters.mongodb.studio;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.AppointmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.ConsumerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.DesignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.TattoistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.AppointmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.ConsumerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.DesignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import es.upm.miw.apaw_practice.domain.models.studio.TattoistCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class StudioSeederService {

    @Autowired
    private TattoistRepository tattoistRepository;
    @Autowired
    private ConsumerRepository consumerRepository;
    @Autowired
    private DesignRepository designRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- Studio Initial Load -----------");
        TattoistEntity[] tattoists = {
                new TattoistEntity(new TattoistCreation("email@test.com",  "Joseph Company", "JC", "2221026541", "Japanese Traditional", (float) 0.0)),
                new TattoistEntity(new TattoistCreation("email1@test.com",  "Maneki Neko", "Ghinko", "2221026542", "Blackwork", (float) 0.0)),
                new TattoistEntity(new TattoistCreation("email2@test.com",  "Joan Mora", "JM", "2221026543", "Neo-Traditional", (float) 0.0)),
                new TattoistEntity(new TattoistCreation("email3@test.com",  "Doru Ma", "Chem", "2221026544", "Blackwork", (float) 0.0)),
                new TattoistEntity(new TattoistCreation("email4@test.com",  "Tengu Neko", "Neko", "2221026545", "American Traditional", (float) 0.0)),
        };
        this.tattoistRepository.saveAll(Arrays.asList(tattoists));

        ConsumerEntity[] consumers = {
                new ConsumerEntity("consumer1@test.com", "Wilma York", "123456789", "Japanese Traditiona", tattoists[1]),
                new ConsumerEntity("consumer2@test.com", "Adem Gonzales", "123456788", "Neo-Traditiona", tattoists[0]),
                new ConsumerEntity("consumer3@test.com", "Bronwyn Coulson", "123456787", "Japanese Traditional", tattoists[2]),
                new ConsumerEntity("consumer4@test.com", "Zayna Crosby", "123456786", "American Traditional", tattoists[1]),
                new ConsumerEntity("consumer5@test.com", "Shakeel Worthington", "123456785", "Blackwork", tattoists[4]),
        };
        this.consumerRepository.saveAll(Arrays.asList(consumers));

        DesignEntity[] designs = {
                new DesignEntity("collaborative", Boolean.FALSE, new BigDecimal("300.00"), "Blackwork", List.of(tattoists[0], tattoists[1])),
                new DesignEntity("single", Boolean.FALSE, new BigDecimal("300.00"), "Blackwork", List.of(tattoists[2])),
                new DesignEntity("available", Boolean.FALSE, new BigDecimal("300.00"), "Blackwork", List.of(tattoists[3], tattoists[4])),
        };
        this.designRepository.saveAll(Arrays.asList(designs));

        AppointmentEntity[] appointments = {
            new AppointmentEntity(LocalDateTime.of(2021, 2, 3, 11, 0),  Boolean.TRUE, designs[0]),
            new AppointmentEntity(LocalDateTime.of(2021, 2, 1, 11, 0),  Boolean.TRUE, designs[1]),
        };
        this.appointmentRepository.saveAll(Arrays.asList(appointments));
    }
    public void deleteAll() {
        this.tattoistRepository.deleteAll();
        this.consumerRepository.deleteAll();
        this.designRepository.deleteAll();
        this.appointmentRepository.deleteAll();
    }
}
