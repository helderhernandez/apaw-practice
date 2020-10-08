package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;

public class TreeFilmDirectorsLeaf implements TreeFilmDirectors {

    private FilmDirectorEntity filmDirectorEntity;

    public TreeFilmDirectorsLeaf(FilmDirectorEntity filmDirectorEntity) {
        this.filmDirectorEntity = filmDirectorEntity;
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String getName() {
        return this.filmDirectorEntity.getName();
    }

    @Override
    public void add(TreeFilmDirectors treeFilmDirectors) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeFilmDirectors treeFilmDirectors) {
        //Do nothing is leaf
    }
}
