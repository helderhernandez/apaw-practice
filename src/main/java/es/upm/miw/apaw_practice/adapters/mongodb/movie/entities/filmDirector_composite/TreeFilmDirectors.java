package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

import java.util.List;

public interface TreeFilmDirectors {

    boolean isComposite();

    String getFilmDirectorsGroupName();

    String getFilmDirectorName();

    void add(TreeFilmDirectors treeFilmDirectors);

    void remove(TreeFilmDirectors treeFilmDirectors);

    List<String> getFilmDirectorsName();

}
