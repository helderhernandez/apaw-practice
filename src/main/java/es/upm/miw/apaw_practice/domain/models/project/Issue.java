package es.upm.miw.apaw_practice.domain.models.project;

import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.DeveloperEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.project.entities.LabelEntity;

import java.time.LocalDateTime;
import java.util.List;

public class Issue {

    private String id;
    private String name;
    private Integer estimatedHours;
    private LocalDateTime dueDate;
    private Boolean done;
    private DeveloperEntity developer;
    private List<LabelEntity> labels;

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

    public DeveloperEntity getDeveloper() {
        return developer;
    }

    public void setDeveloper(DeveloperEntity developer) {
        this.developer = developer;
    }

    public List<LabelEntity> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelEntity> labels) {
        this.labels = labels;
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
