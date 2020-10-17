package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite;

import java.util.List;

public interface TreeGameDevelopers {

    boolean isComposite();

    String getName();

    void add(TreeGameDevelopers treeGameDevelopers);

    void remove(TreeGameDevelopers treeGameDevelopers);

    List<String> getGameDevelopersName();
}
