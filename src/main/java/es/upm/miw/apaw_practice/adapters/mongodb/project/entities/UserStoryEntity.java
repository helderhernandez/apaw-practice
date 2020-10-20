package es.upm.miw.apaw_practice.adapters.mongodb.project.entities;

import es.upm.miw.apaw_practice.domain.models.project.UserStory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Document
public class UserStoryEntity {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer value;
    @DBRef
    private List<IssueEntity> issues;

    public UserStoryEntity() {
        //empty for framework
    }

    public UserStoryEntity(String name, String description, Integer value, List<IssueEntity> issues) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.value = value;
        this.issues = issues;
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

    public List<IssueEntity> getIssues() {
        return issues;
    }

    public void setIssues(List<IssueEntity> issues) {
        this.issues = issues;
    }

    public UserStory toUserStory() {
        UserStory userStory = new UserStory();
        BeanUtils.copyProperties(this, userStory);
        return userStory;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (id.equals(((UserStoryEntity) obj).id));
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserStoryEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", issues=" + issues +
                '}';
    }

}
