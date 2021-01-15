package es.upm.miw.apaw_practice.adapters.mongodb.studio;

import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.AppointmentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.ConsumerRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.DesignRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.daos.TattoistRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.AppointmentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.ConsumerEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.DesignEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.studio.entities.TattoistEntity;
import es.upm.miw.apaw_practice.domain.models.studio.Tattoist;
import es.upm.miw.apaw_practice.domain.models.studio.TattoistCreation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.logging.log4j.LogManager;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
        ConsumerEntity[] consumers = {
                new ConsumerEntity("consumer1@test.com", "Wilma York", "123456789", "Japanese Traditional"),
                new ConsumerEntity("consumer2@test.com", "Adem Gonzales", "123456788", "Neo-Traditional"),
                new ConsumerEntity("consumer3@test.com", "Bronwyn Coulson", "123456787", "Japanese Traditional"),
                new ConsumerEntity("consumer4@test.com", "Zayna Crosby", "123456786", "American Traditional"),
                new ConsumerEntity("consumer5@test.com", "Shakeel Worthington", "123456785", "Blackwork"),
        };
        this.consumerRepository.saveAll(Arrays.asList(consumers));

        TattoistEntity[] tattoists = {
                TattoistEntity.builder().id(UUID.randomUUID().toString()).name("Joseph Company").mainStyle("Japanese Traditional").nickname("JC").phone("2221026541").ranking((float) 0.0).consumers(List.of(consumers[0], consumers[1])).email("email@test.com").build(),
                TattoistEntity.builder().id(UUID.randomUUID().toString()).name("Maneki Neko").mainStyle("Blackwork").nickname("Ghinko").phone("2221026543").ranking((float) 0.0).consumers(List.of(consumers[0])).email("email1@test.com").build(),
                TattoistEntity.builder().id(UUID.randomUUID().toString()).name("Joan Mora").mainStyle("Neo-Traditional").nickname("JM").phone("2221026542").ranking((float) 0.0).consumers(List.of(consumers[0], consumers[1], consumers[2])).email("email2@test.com").build(),
                TattoistEntity.builder().id(UUID.randomUUID().toString()).name("Chem").mainStyle("Blackwork").nickname("Chem").phone("2221026544").ranking((float) 0.0).consumers(List.of(consumers[0], consumers[4])).email("email3@test.com").build(),
                TattoistEntity.builder().id(UUID.randomUUID().toString()).name("Tengu Neko").mainStyle("American Traditional").nickname("Neko").phone("2221026545").ranking((float) 0.0).consumers(List.of(consumers[4])).email("email4@test.com").build(),
        };
        this.tattoistRepository.saveAll(Arrays.asList(tattoists));

        DesignEntity[] designs = {
                new DesignEntity("collaborative", Boolean.FALSE, new BigDecimal("250.00"), "American Traditional", List.of(tattoists[0], tattoists[1])),
                new DesignEntity("single", Boolean.FALSE, new BigDecimal("300.00"), "Blackwork", List.of(tattoists[2])),
                new DesignEntity("available", Boolean.FALSE, new BigDecimal("400.00"), "Japanese Traditional", List.of(tattoists[3], tattoists[4])),
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
