package es.upm.miw.apaw_practice.domain.models.garage.composite;

import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;

import java.util.List;

public class TreeVehicleLeaf implements TreeVehicle {

    private Vehicle vehicle;

    public TreeVehicleLeaf(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String getModel() {
        return this.vehicle.getModel();
    }

    @Override
    public List<String> getVehiclesModel() {
        return List.of(this.vehicle.getModel());
    }

    @Override
    public List<TreeVehicle> getVehicles() {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void add(TreeVehicle treeVehicle) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public void remove(TreeVehicle treeVehicle) {
        throw new UnsupportedOperationException("Unsupported action. This is a leaf");
    }

    @Override
    public boolean isComposite() {
        return Boolean.FALSE;
    }

    @Override
    public int numberOfDescendants() {
        return 0;
    }
}
