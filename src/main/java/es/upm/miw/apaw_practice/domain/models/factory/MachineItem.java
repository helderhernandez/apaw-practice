package es.upm.miw.apaw_practice.domain.models.factory;

public class MachineItem {
    private Boolean active;

    public MachineItem() {
        //empty for framework
    }

    public MachineItem(Boolean active) {
        this.active = active;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "MachineItem{" +
                "active=" + active +
                '}';
    }
}
