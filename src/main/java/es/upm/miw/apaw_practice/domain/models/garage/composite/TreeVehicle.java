package es.upm.miw.apaw_practice.domain.models.garage.composite;

import java.util.List;

public interface TreeVehicle {

    String getModel();

    List<String> getVehiclesModel();

    List<TreeVehicle> getVehicles();

    void add(TreeVehicle treeVehicle);

    void remove(TreeVehicle treeVehicle);

    boolean isComposite();

    int numberOfDescendants();

}
