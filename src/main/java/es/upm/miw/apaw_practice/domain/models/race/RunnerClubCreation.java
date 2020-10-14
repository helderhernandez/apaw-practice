package es.upm.miw.apaw_practice.domain.models.race;

import java.time.LocalDateTime;

public class RunnerClubCreation {

    private String name;
    private String location;
    private LocalDateTime foundationDate;

    public RunnerClubCreation() {
        // empty for framework
    }

    public RunnerClubCreation(String name, String location, LocalDateTime foundationDate) {
        this.name = name;
        this.location = location;
        this.foundationDate = foundationDate;
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
        return this == obj || obj != null && getClass() == obj.getClass() && (name.equals(((RunnerClubCreation) obj).name));
    }

    @Override
    public String toString() {
        return "RunnerClubCreation{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", foundationDate=" + foundationDate +
                '}';
    }
}
