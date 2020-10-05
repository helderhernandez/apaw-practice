package es.upm.miw.apaw_practice.adapters.rest.movie;

import es.upm.miw.apaw_practice.domain.models.movie.Cinema;

public class BasicCinemaDto {
    private String id;
    private String cinemaName;

    public BasicCinemaDto() {
    }

    public BasicCinemaDto(Cinema cinema) {
        this.id = cinema.getId();
        this.cinemaName = cinema.getCinemaName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    @Override
    public String toString() {
        return "BasicCinemaDto{" +
                "id='" + id + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                '}';
    }
}
