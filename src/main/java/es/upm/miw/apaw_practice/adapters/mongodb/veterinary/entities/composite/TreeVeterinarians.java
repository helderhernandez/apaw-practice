package es.upm.miw.apaw_practice.adapters.mongodb.veterinary.entities.composite;

import java.util.List;

public interface TreeVeterinarians {
    boolean isComposite();

    String getName();

    void add(TreeVeterinarians treeVeterinarians);

    void remove(TreeVeterinarians treeVeterinarians);

    List<String> getVeterinariansName();
}
