package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmDirector_composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public String getFilmDirectorsGroupName() {
        return filmDirectorsGroupName;
    }

    @Override
    public String getFilmDirectorName() {
        return null;
    }

    @Override
    public void add(TreeFilmDirectors treeFilmDirectors) {
        treeFilmDirectorsList.add(treeFilmDirectors);
    }

    @Override
    public void remove(TreeFilmDirectors treeFilmDirectors) {
        treeFilmDirectorsList.remove(treeFilmDirectors);
    }

    @Override
    public List<String> getFilmDirectorsName() {
        return treeFilmDirectorsList.stream()
                .filter(treeFilmDirectors -> treeFilmDirectors.getFilmDirectorName() != null)
                .map(treeFilmDirectors -> treeFilmDirectors.getFilmDirectorName())
                .collect(Collectors.toList());
    }
}
