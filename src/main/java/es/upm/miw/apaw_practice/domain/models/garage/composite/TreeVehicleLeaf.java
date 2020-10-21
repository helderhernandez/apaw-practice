package es.upm.miw.apaw_practice.domain.models.garage.composite;

import es.upm.miw.apaw_practice.domain.models.garage.Vehicle;

import java.util.List;

public class TreeVehicleLeaf implements TreeVehicle {

    private static final String UNSUPPORTED_OPERATION_MESSAGE = "Unsupported action. This is a leaf";

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
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override
    public void add(TreeVehicle treeVehicle) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    @Override
    public void remove(TreeVehicle treeVehicle) {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
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
