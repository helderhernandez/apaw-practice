package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.mongodb.sportcentre.entities.SpecialityEntity;
import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Instructor;
import es.upm.miw.apaw_practice.domain.models.sportcentre.InstructorCreation;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Speciality;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RestTestConfig
public class InstructorResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreate(){
        Speciality speciality = new SpecialityEntity("spec8", "Padel", "Padel training", 120, true).toSpeciality();
        InstructorCreation instructorCreation = new InstructorCreation("222222222A", "Eduardo", "Jimenez", new BigDecimal(1300), List.of(speciality));
        this.webTestClient
                .post()
                .uri(InstructorResource.INSTRUCTORS)
                .body(BodyInserters.fromValue(instructorCreation))
                .exchange()
                .expectStatus().isOk()
                .expectBody(Instructor.class)
                .value(Assertions::assertNotNull)
                .value(instructor -> assertNotNull(instructor.getId()));
    }

}
