package es.upm.miw.apaw_practice.domain.model.filmforum.composite;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;
import es.upm.miw.apaw_practice.domain.models.filmforum.composite.FilmCommentComponentTree;
import es.upm.miw.apaw_practice.domain.models.filmforum.composite.FilmCommentComposite;
import es.upm.miw.apaw_practice.domain.models.filmforum.composite.FilmCommentLeaf;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilmCommentCompositeTest {
    @Test
    void testFilmCommentCompositeAddingLeafs() {
        FilmCommentComponentTree thread = new FilmCommentComposite();
        FilmCommentComponentTree thread2 = new FilmCommentComposite();

        thread.add(new FilmCommentLeaf(new FilmComment("1", null, "content1", 0, null)));
        thread.add(new FilmCommentLeaf(new FilmComment("2", null, "content2", 0, null)));
        thread.add(new FilmCommentLeaf(new FilmComment("3", null, "content3", 0, null)));
        thread2.add(new FilmCommentLeaf(new FilmComment("4", null, "content4", 0, null)));
        thread2.add(new FilmCommentLeaf(new FilmComment("5", null, "content5", 0, null)));
        thread2.add(new FilmCommentLeaf(new FilmComment("6", null, "content6", 0, null)));
        thread.add(thread2);

        String expectedContent1 = "content1,content2,content3,content4,content5,content6";
        assertEquals(thread.getCommentContent(), expectedContent1);
    }

    @Test
    void testFilmCommentCompositeRemovingLeafs() {
        FilmCommentComponentTree thread = new FilmCommentComposite();
        FilmCommentComponentTree thread2 = new FilmCommentComposite();
        FilmCommentLeaf leafToDelete1 = new FilmCommentLeaf(new FilmComment("2", null, "content2", 0, null));
        FilmCommentLeaf leafToDelete2 = new FilmCommentLeaf(new FilmComment("5", null, "content5", 0, null));
        thread.add(new FilmCommentLeaf(new FilmComment("1", null, "content1", 0, null)));
        thread.add(leafToDelete1);
        thread.add(new FilmCommentLeaf(new FilmComment("3", null, "content3", 0, null)));
        thread2.add(new FilmCommentLeaf(new FilmComment("4", null, "content4", 0, null)));
        thread2.add(leafToDelete2);
        thread2.add(new FilmCommentLeaf(new FilmComment("6", null, "content6", 0, null)));
        thread.add(thread2);

        thread.remove(leafToDelete1);
        thread2.remove(leafToDelete2);

        String expectedContent2 = "content1,content3,content4,content6";
        assertEquals(expectedContent2, thread.getCommentContent());
    }
}
