package es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite;

import es.upm.miw.apaw_practice.adapters.mongodb.race.entities.RunnerEntity;

public class TreeRunnersLeaf implements TreeRunners {

    private RunnerEntity runnerEntity;

    public TreeRunnersLeaf(RunnerEntity runnerEntity) {
        this.runnerEntity = runnerEntity;
    }

    @Override
    public String runnerClubName() {
        return runnerEntity.getRunnerClubEntity().getName();
    }

    @Override
    public boolean isComposite() {
        return false;
    }

    @Override
    public void add(TreeRunners treeRunners) {
        // Do nothing because is leaf
    }

    @Override
    public void remove(TreeRunners treeRunners) {
        // Do nothing because is leaf
    }
}
