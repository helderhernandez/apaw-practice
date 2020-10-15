package es.upm.miw.apaw_practice.domain.services.socialnetwork;

import es.upm.miw.apaw_practice.TestConfig;
import es.upm.miw.apaw_practice.domain.models.socialnetwork.SocialPost;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestConfig
public class SocialPostServiceIT {

    @Autowired
    private SocialPostService socialPostService;

    @Test
    void testCreate() {
        String uuid = UUID.randomUUID().toString();
        SocialPost socialPost = SocialPost.builder().id(uuid).postingDate(LocalDateTime.now())
                .content("this is the content").shared(0).likes(0).build();
        this.socialPostService.create(socialPost);
        Optional<SocialPost> socialPostCreated = this.socialPostService.readAll()
                .filter(post -> post.getId().equals(uuid))
                .findFirst();
        assertTrue(socialPostCreated.isPresent());
        assertEquals("this is the content", socialPostCreated.get().getContent());
        assertEquals(0, socialPostCreated.get().getShared());
        assertEquals(0, socialPostCreated.get().getLikes());
    }

}
