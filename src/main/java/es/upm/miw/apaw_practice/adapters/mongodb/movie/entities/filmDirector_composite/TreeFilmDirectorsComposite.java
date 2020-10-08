package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

import java.util.ArrayList;
import java.util.List;

public class TreeFilmDirectorsComposite implements TreeFilmDirectors {

    private String filmDirectorsGroupName;

    private List<TreeFilmDirectors> treeFilmDirectorsList;

    public TreeFilmDirectorsComposite(String filmDirectorsGroupName) {
        this.filmDirectorsGroupName = filmDirectorsGroupName;
        this.treeFilmDirectorsList = new ArrayList<>();
    }

    //TODO Make a method that returns the list of directors of the Composite

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String getName() {
        return this.filmDirectorsGroupName;
    }

    @Override
    public void add(TreeFilmDirectors treeFilmDirectors) {
        treeFilmDirectorsList.add(treeFilmDirectors);
    }

    @Override
    public void remove(TreeFilmDirectors treeFilmDirectors) {
        treeFilmDirectorsList.remove(treeFilmDirectors);
    }
}
