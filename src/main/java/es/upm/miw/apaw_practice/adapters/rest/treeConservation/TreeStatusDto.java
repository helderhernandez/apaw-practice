package es.upm.miw.apaw_practice.adapters.rest.treeConservation;

public class TreeStatusDto {
    String treeStatus;

    public String getTreeStatus() {
        return treeStatus;
    }

    public void setTreeStatus(String treeStatus) {
        this.treeStatus = treeStatus;
    }

    @Override
    public String toString() {
        return "TreeStatusDto{" +
                "treeStatus='" + treeStatus + '\'' +
                '}';
    }
}
