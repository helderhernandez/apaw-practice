package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.adapters.rest.shop.ArticleResource;
import es.upm.miw.apaw_practice.domain.models.movie.Cinema;
import es.upm.miw.apaw_practice.domain.models.school.Course;
import es.upm.miw.apaw_practice.domain.models.school.Student;
import es.upm.miw.apaw_practice.domain.models.shop.Article;
import es.upm.miw.apaw_practice.domain.models.shop.Tag;
import es.upm.miw.apaw_practice.domain.models.sportcentre.Session;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class SessionResourceIT {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete(){
        this.webTestClient
                .delete()
                .uri(SessionResource.SESSIONS + SessionResource.ID_ID, "not_id")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void findNameAssistantsSessionByInstructor(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SessionResource.SESSIONS + SessionResource.SEARCH_INSTRUCTOR)
                                .queryParam("q", "name:Gonzalo")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .consumeWith(responseList -> {
                    assertNotNull(responseList.getResponseBody());
                    List<String> nameAssistants = responseList.getResponseBody();
                    assertTrue(nameAssistants.get(0).contains("Elena"));
                    assertTrue(nameAssistants.get(0).contains("Julia"));
                    assertFalse(nameAssistants.get(0).contains("Jose"));
                });
    }

    @Test
    void findSessionBySpecialityTitle(){
        this.webTestClient
                .get()
                .uri(uriBuilder ->
                        uriBuilder.path(SessionResource.SESSIONS + SessionResource.SEARCH_SPECIALITY)
                                .queryParam("q", "title:Yoga")
                                .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(BasicSessionDto.class)
                .value(Assertions::assertNotNull)
                .value(sessionDtoList -> sessionDtoList.get(0).getRoomNumber(), equalTo(2));
    }

}
