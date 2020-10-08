package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

import es.upm.miw.apaw_practice.domain.models.project.Issue;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class IssueEntity {

    @Id
    private String id;
    private String name;
    private Integer estimatedHours;
    private LocalDateTime dueDate;
    private Boolean done;
    @DBRef
    private DeveloperEntity developer;
    @DBRef
    private List<LabelEntity> labels;

    private IssueEntity() {
        //empty for framework
    }

    public IssueEntity(String name, Integer estimatedHours, DeveloperEntity developer, List<LabelEntity> labels) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.estimatedHours = estimatedHours;
        this.dueDate = LocalDateTime.now();
        this.done = false;
        this.developer = developer;
        this.labels = labels;
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

    public Issue toIssue() {
        Issue issue = new Issue();
        BeanUtils.copyProperties(this, issue);
        return issue;
    }

    public void fromIssue(Issue issue) {
        BeanUtils.copyProperties(issue, this);
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((IssueEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "IssueEntity{" +
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
