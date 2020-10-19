package es.upm.miw.apaw_practice.adapters.rest.article;

import es.upm.miw.apaw_practice.domain.models.article.Author;
import es.upm.miw.apaw_practice.domain.services.article.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(AuthorResource.AUTHORS)
public class AuthorResource {
    static final String AUTHORS = "/article/authors";

    static final String SEARCH = "/search";

    public final AuthorService authorService;

    @Autowired
    public  AuthorResource(AuthorService authorService) { this.authorService = authorService; }

    @GetMapping
    public Stream<Author> readAll() { return this.authorService.readAll(); }
}
