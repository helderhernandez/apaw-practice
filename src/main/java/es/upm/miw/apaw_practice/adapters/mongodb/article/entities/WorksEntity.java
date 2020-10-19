package es.upm.miw.apaw_practice.adapters.mongodb.article.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;


@Document
public class WorksEntity {
    @DBRef
    private List<AuthorEntity> authorEntityList;
    @DBRef
    private List<EssayEntity> essayEntityList;
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String ismn;
    private LocalDate publicationdate;
    private String description;
    private BigDecimal price;
    private Byte grade;

    public WorksEntity() {
        //empty from framework
    }

    public WorksEntity(List<AuthorEntity> authorEntyList, List<EssayEntity> essayEntyList, String name, String ismn, LocalDate publicationdate, String description, BigDecimal price, Byte grade) {
        this.authorEntityList = authorEntityList;
        this.essayEntityList = essayEntityList;
        this.name = name;
        this.ismn = ismn;
        this.publicationdate = publicationdate;
        this.description = description;
        this.price = price;
        this.grade = grade;
    }

    public List<AuthorEntity> getAuthorEntityList() {
        return authorEntityList;
    }

    public void setAuthorEntityList(List<AuthorEntity> authorEntityList) {
        this.authorEntityList = authorEntityList;
    }

    public List<EssayEntity> getEssayEntityList() {
        return essayEntityList;
    }

    public void setEssayEntityList(List<EssayEntity> essayEntityList) {
        this.essayEntityList = essayEntityList;
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

    public String getIsmn() {
        return ismn;
    }

    public void setIsmn(String ismn) {
        this.ismn = ismn;
    }

    public LocalDate getPublicationdate() {
        return publicationdate;
    }

    public void setPublicationdate(LocalDate publicationdate) {
        this.publicationdate = publicationdate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Byte getGrade() {
        return grade;
    }

    public void setGrade(Byte grade) {
        this.grade = grade;
    }

    @Override
    public int hashCode() {
        return ismn.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (ismn.equals(((es.upm.miw.apaw_practice.adapters.mongodb.article.entities.WorksEntity) obj).ismn));
    }

    @Override
    public String toString() {
        return "WorksEntity{" +
                "authorEntityList=" + authorEntityList +
                ", essayEntityList=" + essayEntityList +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ismn='" + ismn + '\'' +
                ", publicationdate=" + publicationdate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                '}';
    }
}
