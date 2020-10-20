package es.upm.miw.apaw_practice.domain.models.garage.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeVehicleComposite implements TreeVehicle{

    private String model;
    private List<TreeVehicle> treeVehicles;

    public TreeVehicleComposite(String model) {
        this.model = model;
        this.treeVehicles = new ArrayList<>();
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public List<String> getVehiclesModel() {
        return this.treeVehicles.stream()
                .map(TreeVehicle::getModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<TreeVehicle> getVehicles() {
        return this.treeVehicles;
    }

    @Override
    public void add(TreeVehicle treeVehicle) {
        this.treeVehicles.add(treeVehicle);
    }

    @Override
    public void remove(TreeVehicle treeVehicle) {
        this.treeVehicles.remove(treeVehicle);
    }

    @Override
    public boolean isComposite() {
        return Boolean.TRUE;
    }

    @Override
    public int numberOfDescendants() {
        return this.treeVehicles.size();
    }
}
