package es.upm.miw.apaw_practice.adapters.mongodb.tree_conservation.entities.composite;

import java.util.List;

public interface TreeDiseases {

    String getName();

    void add(TreeDiseases treeDiseases);

    void remove(TreeDiseases treeDiseases);

    boolean isComposite();

    List<String> getDiseasesName();
}
