package es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite;

import java.util.ArrayList;
import java.util.List;

public class TreeRunnersComposite implements TreeRunners {

    private String runnerClubName;
    private List<TreeRunners> treeRunnersList;

    public TreeRunnersComposite(String runnerClubName) {
        this.runnerClubName = runnerClubName;
        this.treeRunnersList = new ArrayList<>();
    }

    @Override
    public String runnerClubName() {
        return runnerClubName;
    }

    @Override
    public boolean isComposite() {
        return true;
    }

    @Override
    public void add(TreeRunners treeRunners) {
        this.treeRunnersList.add(treeRunners);
    }

    @Override
    public void remove(TreeRunners treeRunners) {
        this.treeRunnersList.remove(treeRunners);
    }
}
