package es.upm.miw.apaw_practice.business.rest.system;

import es.upm.miw.apaw_practice.business.rest.RestTestConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.web.reactive.server.WebTestClient;

import static es.upm.miw.apaw_practice.business.rest.system.SystemResource.SYSTEM;
import static es.upm.miw.apaw_practice.business.rest.system.SystemResource.VERSION_BADGE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RestTestConfig
class SystemResourceIT {
    @Autowired
    private WebTestClient webTestClient;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Test
    void testReadVersionBadge() {
        this.webTestClient
                .get().uri(contextPath + SYSTEM + VERSION_BADGE)
                .exchange()
                .expectStatus().isOk()
                .expectBody(byte[].class)
                .value(Assertions::assertNotNull)
                .value(svg -> assertTrue(new String(svg).startsWith("<svg")));
    }

    @Test
    void testReadAppInfo() {
        this.webTestClient
                .get().uri(contextPath + SYSTEM + SystemResource.APP_INFO)
                .exchange()
                .expectStatus().isOk()
                .expectBody(AppInfoDto.class)
                .value(Assertions::assertNotNull)
                .value(appInfo -> {
                    assertNotNull(appInfo.getApplication());
                    assertNotNull(appInfo.getVersion());
                    assertNotNull(appInfo.getBuild());
                    assertNotNull(appInfo.getProfile());
                });
    }
}
