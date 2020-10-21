package es.upm.miw.apaw_practice.domain.models.project;

import java.time.LocalDateTime;
import java.util.List;

public class Issue {

    private String id;
    private String name;
    private Integer estimatedHours;
    private LocalDateTime dueDate;
    private Boolean done;
    private Developer developer;
    private List<Label> labels;

    public Issue() {
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(Integer estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public boolean hasLabel(String labelName) {
        for (Label label : labels) {
            if (label.getName().equals(labelName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", estimatedHours=" + estimatedHours +
                ", dueDate=" + dueDate +
                ", done=" + done +
                ", developer=" + developer +
                ", labels=" + labels +
                '}';
    }

}
