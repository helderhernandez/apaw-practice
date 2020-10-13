package es.upm.miw.apaw_practice.domain.models.article;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Works {
    private String id;
    private String name;
    private String ismn;
    private LocalDate publicationdate;
    private String description;
    private BigDecimal price;
    private Byte grade;

    public Works() {
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
    public String toString() {
        return "Works{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", ismn=" + ismn +
                ", publicationdate=" + publicationdate +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", grade=" + grade +
                '}';
    }
}
