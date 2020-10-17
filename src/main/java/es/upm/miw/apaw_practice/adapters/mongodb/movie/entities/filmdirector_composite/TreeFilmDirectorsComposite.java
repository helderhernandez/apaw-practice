package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.filmdirector_composite;

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

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public String getName() {
        return filmDirectorsGroupName;
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
                .filter(treeFilmDirectors -> !treeFilmDirectors.isComposite())
                .map(TreeFilmDirectors::getName)
                .collect(Collectors.toList());
    }
}
