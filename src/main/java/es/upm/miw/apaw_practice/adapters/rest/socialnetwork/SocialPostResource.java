package es.upm.miw.apaw_practice.adapters.rest.socialnetwork;

import es.upm.miw.apaw_practice.domain.services.socialnetwork.SocialPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(SocialPostResource.POSTS)
public class SocialPostResource {

    static final String POSTS = "/socialnetwork/posts";

    private SocialPostService socialPostService;

    @Autowired
    public SocialPostResource(SocialPostService socialPostService) {
        this.socialPostService = socialPostService;
    }

    @GetMapping
    public Stream<BasicPostDto> readAll() {
        return this.socialPostService.readAll().map(BasicPostDto::new);
    }

}
