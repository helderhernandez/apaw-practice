package es.upm.miw.apaw_practice.domain.models.movie;

import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.FilmRoomEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.movie.entities.MovieEntity;

import java.math.BigDecimal;
import java.util.List;

public class Cinema {
    private String id;
    private List<MovieEntity> movies;
    private List<FilmRoomEntity> filmRooms;
    private String cinemaName;
    private BigDecimal movieTicketPrice;
    private String city;

    public Cinema() {
        //empty for framework
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<MovieEntity> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieEntity> movies) {
        this.movies = movies;
    }

    public List<FilmRoomEntity> getFilmRooms() {
        return filmRooms;
    }

    public void setFilmRooms(List<FilmRoomEntity> filmRooms) {
        this.filmRooms = filmRooms;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public BigDecimal getMovieTicketPrice() {
        return movieTicketPrice;
    }

    public void setMovieTicketPrice(BigDecimal movieTicketPrice) {
        this.movieTicketPrice = movieTicketPrice;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "id='" + id + '\'' +
                ", movies=" + movies +
                ", filmRooms=" + filmRooms +
                ", cinemaName='" + cinemaName + '\'' +
                ", movieTicketPrice=" + movieTicketPrice +
                ", city='" + city + '\'' +
                '}';
    }
}
