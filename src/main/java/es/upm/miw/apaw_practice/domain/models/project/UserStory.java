package es.upm.miw.apaw_practice.domain.models.project;

import java.util.List;

public class UserStory {

    private String id;
    private String name;
    private String description;
    private Integer value;
    private List<Issue> issues;

    public UserStory() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public boolean hasLabel(String labelName) {
        for (Issue issue : issues) {
            if (issue.hasLabel(labelName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "UserStory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", issues=" + issues +
                '}';
    }

}
