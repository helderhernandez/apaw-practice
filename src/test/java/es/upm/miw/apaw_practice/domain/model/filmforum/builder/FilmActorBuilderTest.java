package es.upm.miw.apaw_practice.domain.model.filmforum.builder;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmActor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class FilmActorBuilderTest {
    @Test
    void testFilmActorBuilder() {
        FilmActor actor = FilmActor.builder().id("id1").name("test").surname("surname").age(10).build();
        assertEquals("id1", actor.getId());
        assertEquals("test", actor.getName());
        assertEquals("surname", actor.getSurname());
        assertEquals(10, actor.getAge());
    }

    @Test
    void testFilmActorBuilderRandomId() {
        FilmActor actor = FilmActor.builder().randomId().name("test").surname("surname").age(10).build();
        assertNotNull(actor.getId());
    }
}
