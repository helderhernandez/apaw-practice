package es.upm.miw.apaw_practice.domain.models.hospital;

public class IllnessContagiousUpdating {

    private Integer phase;
    private Boolean contagious;

    public IllnessContagiousUpdating() {
        //empty for framework
    }

    public IllnessContagiousUpdating(Integer phase, Boolean contagious) {
        this.phase = phase;
        this.contagious = contagious;
    }

    public Integer getPhase() {
        return phase;
    }

    public void setPhase(Integer phase) {
        this.phase = phase;
    }

    public Boolean getContagious() {
        return contagious;
    }

    public void setContagious(Boolean contagious) {
        this.contagious = contagious;
    }

    @Override
    public String toString() {
        return "IllnessContagiousUpdating{" +
                "phase=" + phase +
                ", contagious=" + contagious +
                '}';
    }
}
