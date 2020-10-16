package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeGameDevelopersComposite implements TreeGameDevelopers {

    private String name;
    private List<TreeGameDevelopers> treeGameDevelopersList;

    public TreeGameDevelopersComposite(String name) {
        this.name = name;
        this.treeGameDevelopersList= new ArrayList<>();
    }


    @Override
    public boolean isComposite() { return true; }

    @Override
    public String getName() { return this.name; }

    @Override
    public void add(TreeGameDevelopers treeGameDevelopers) {
        this.treeGameDevelopersList.add(treeGameDevelopers);
    }

    @Override
    public void remove(TreeGameDevelopers treeGameDevelopers) {
        this.treeGameDevelopersList.remove(treeGameDevelopers);
    }

    @Override
    public List<String> getGameDevelopersName() {
        return this.treeGameDevelopersList.stream()
                .filter(treeGameDevelopers -> !treeGameDevelopers.isComposite())
                .map(TreeGameDevelopers::getName)
                .collect(Collectors.toList());
    }
}
