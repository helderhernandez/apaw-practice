package es.upm.miw.apaw_practice.adapters.mongodb.race.entities.composite;

public interface TreeRunners {

    String runnerClubName();

    boolean isComposite();

    void add(TreeRunners treeRunners);

    void remove(TreeRunners treeRunners);

}
