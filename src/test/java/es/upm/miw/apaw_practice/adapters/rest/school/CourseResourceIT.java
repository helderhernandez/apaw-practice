package es.upm.miw.apaw_practice.adapters.rest.school;

import es.upm.miw.apaw_practice.adapters.rest.RestTestConfig;
import es.upm.miw.apaw_practice.domain.models.school.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@RestTestConfig
public class CourseResourceIT {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testDelete() {
        this.webTestClient
                .delete()
                .uri(CourseResource.COURSES + CourseResource.ID_ID, "kk")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void testFindCoursesByTeacherName() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CourseResource.COURSES + CourseResource.SEARCH)
                        .queryParam("q", "Pablo")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Course.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> tagList = entityList.getResponseBody().stream()
                            .map(Course::getAcademicLevel)
                            .collect(Collectors.toList());
                    assertTrue(tagList.containsAll(Arrays.asList("Primary", "Secondary", "Primary")));
                });
    }

    @Test
    void testFindCoursesByTeacherNameNotFound() {
        this.webTestClient
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path(CourseResource.COURSES + CourseResource.SEARCH)
                        .queryParam("q", "Pablodfgfdg")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Course.class)
                .consumeWith(entityList -> {
                    assertNotNull(entityList.getResponseBody());
                    List<String> tagList = entityList.getResponseBody().stream()
                            .map(Course::getAcademicLevel)
                            .collect(Collectors.toList());
                    assertFalse(tagList.containsAll(Arrays.asList("Primary", "Secondary", "Primary")));
                });
    }
}
