package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

public interface TreeFilmDirectors {

    boolean isComposite();

    String getName();

    void add(TreeFilmDirectors treeFilmDirectors);

    void remove(TreeFilmDirectors treeFilmDirectors);

}
