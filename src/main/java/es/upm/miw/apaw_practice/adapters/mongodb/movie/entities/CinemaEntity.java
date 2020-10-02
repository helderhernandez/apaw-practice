package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Document
public class CinemaEntity {
    @Id
    private String id;
    @DBRef
    private List<MovieEntity> movies;
    private List<FilmRoomEntity> filmRooms;
    @Indexed(unique = true)
    private String cinemaName;
    private BigDecimal movieTicketPrice;
    private String city;

    public CinemaEntity() {
        //empty for framework
    }

    public CinemaEntity(List<MovieEntity> movies, List<FilmRoomEntity> filmRooms, String cinemaName, BigDecimal movieTicketPrice, String city) {
        this.movies = movies;
        this.filmRooms = filmRooms;
        this.cinemaName = cinemaName;
        this.movieTicketPrice = movieTicketPrice;
        this.city = city;
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
    public int hashCode() {
        return cinemaName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || obj != null && getClass() == obj.getClass() && (cinemaName.equals(((CinemaEntity) obj).cinemaName));
    }

    @Override
    public String toString() {
        return "CinemaEntity{" +
                "id='" + id + '\'' +
                ", movies=" + movies +
                ", filmRooms=" + filmRooms +
                ", cinemaName='" + cinemaName + '\'' +
                ", movieTicketPrice=" + movieTicketPrice +
                ", city='" + city + '\'' +
                '}';
    }
}
