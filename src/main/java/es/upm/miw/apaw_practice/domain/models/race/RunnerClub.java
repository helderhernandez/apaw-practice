package es.upm.miw.apaw_practice.domain.models.race;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class RunnerClub {
    @Id
    private String id;
    private String name;
    private String location;
    private LocalDateTime foundationDate;

    public RunnerClub() {
        // empty for framework
    }

    public RunnerClub(String id, String name, String location, LocalDateTime foundationDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.foundationDate = foundationDate;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getFoundationDate() {
        return foundationDate;
    }

    public void setFoundationDate(LocalDateTime foundationDate) {
        this.foundationDate = foundationDate;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((RunnerClub) obj).name));
    }

    @Override
    public String toString() {
        return "RunnerClub{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
