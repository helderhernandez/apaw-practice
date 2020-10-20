package es.upm.miw.apaw_practice.adapters.mongodb.treeConservation.entities.composite;

import java.util.List;

public interface TreeDiseases {

    String getName();

    void add(TreeDiseases treeDiseases);

    void remove(TreeDiseases treeDiseases);

    boolean isComposite();

    List<String> getDiseasesName();
}
