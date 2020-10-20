package es.upm.miw.apaw_practice.domain.models.filmforum.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilmCommentComposite extends FilmCommentComponentTree {
    public List<FilmCommentComponentTree> references;

    public FilmCommentComposite() {
        references = new ArrayList<>();
    }

    @Override
    public String getCommentContent() {
        return references.stream()
                .map(FilmCommentComponentTree::getCommentContent)
                .collect(Collectors.joining(","));
    }

    @Override
    public void add(FilmCommentComponentTree component) {
        this.references.add(component);
    }

    @Override
    public void remove(FilmCommentComponentTree component) {
        this.references.remove(component);
    }
}
