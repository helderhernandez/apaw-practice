package es.upm.miw.apaw_practice.domain.models.filmforum.composite;

import es.upm.miw.apaw_practice.domain.models.filmforum.FilmComment;

public class FilmCommentLeaf extends FilmCommentComponentTree {
    FilmComment comment;

    public FilmCommentLeaf(FilmComment comment) {
        this.comment = comment;
    }

    @Override
    public String getCommentContent() {
        return comment.getContent();
    }

    @Override
    public void add(FilmCommentComponentTree component) {
        // do nothing because it is leaf
    }

    @Override
    public void remove(FilmCommentComponentTree component) {
        // do nothing because it is leaf
    }
}
