package es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.videogame.entities.GameDeveloperEntity;

import java.util.List;

public class GameDevelopersLeaf implements TreeGameDevelopers {

    private GameDeveloperEntity gameDeveloperEntity;

    public GameDevelopersLeaf(GameDeveloperEntity gameDeveloperEntity) {
        this.gameDeveloperEntity = gameDeveloperEntity;
    }


    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public String getName() {
        return this.gameDeveloperEntity.getName();
    }


    @Override
    public void add(TreeGameDevelopers treeGameDevelopers) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeGameDevelopers treeGameDevelopers) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public List<String> getGameDevelopersName() {
        return List.of(gameDeveloperEntity.getName());
    }
}
