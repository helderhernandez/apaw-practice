package es.upm.miw.apaw_practice.domain.models.factory;

public class MachineItem {
    private Boolean isActive;

    public MachineItem() {
        //empty for framework
    }

    public MachineItem(Boolean isActive) {
        this.isActive = isActive;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "MachineItem{" +
                "isActive=" + isActive +
                '}';
    }
}
