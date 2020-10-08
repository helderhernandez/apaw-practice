package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmDirectorEntity;

import java.util.List;

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
    public String getFilmDirectorsGroupName() {
        return null;
    }

    @Override
    public String getFilmDirectorName() {
        return filmDirectorEntity.getName();
    }

    @Override
    public void add(TreeFilmDirectors treeFilmDirectors) {
        //Do nothing is leaf
    }

    @Override
    public void remove(TreeFilmDirectors treeFilmDirectors) {
        //Do nothing is leaf
    }

    @Override
    public List<String> getFilmDirectorsName() {
        return null;
    }
}
