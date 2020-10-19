package es.upm.miw.apaw_practice.adapters.mongodb.race.entities;

import es.upm.miw.apaw_practice.domain.models.race.Runner;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class RunnerEntity {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String dni;
    private Integer dorsal;
    private Boolean professional;
    @DBRef
    private RunnerClubEntity runnerClubEntity;

    public RunnerEntity() {
        // empty for framework
    }

    public RunnerEntity(String id, String name, String dni, Integer dorsal, Boolean professional, RunnerClubEntity runnerClubEntity) {
        this.id = id;
        this.name = name;
        this.dni = dni;
        this.dorsal = dorsal;
        this.professional = professional;
        this.runnerClubEntity = runnerClubEntity;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Boolean getProfessional() {
        return professional;
    }

    public void setProfessional(Boolean professional) {
        this.professional = professional;
    }

    public RunnerClubEntity getRunnerClubEntity() {
        return runnerClubEntity;
    }

    public void setRunnerClubEntity(RunnerClubEntity runnerClubEntity) {
        this.runnerClubEntity = runnerClubEntity;
    }

    @Override
    public int hashCode() {
        return this.dni.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (dni.equals(((RunnerEntity) obj).dni));
    }

    @Override
    public String toString() {
        return "RunnerEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dni='" + dni + '\'' +
                ", dorsal=" + dorsal +
                ", professional=" + professional +
                ", runnerClubEntity=" + runnerClubEntity +
                '}';
    }

    public Runner toRunner() {
        return new Runner(this.id, this.name, this.dni, this.dorsal, this.professional, this.runnerClubEntity.toRunnerClub());
    }

    public void fromRunner(Runner runner) {
        this.id = runner.getId();
        this.name = runner.getName();
        this.dni = runner.getDni();
        this.dorsal = runner.getDorsal();
        this.professional = runner.getProfessional();
        RunnerClubEntity runnerClubEnt = new RunnerClubEntity();
        runnerClubEnt.fromRunnerClub(runner.getRunnerClub());
        this.runnerClubEntity = runnerClubEnt;
    }
}
