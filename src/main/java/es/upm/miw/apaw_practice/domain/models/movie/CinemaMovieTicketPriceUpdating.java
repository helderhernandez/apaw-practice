package es.upm.miw.apaw_practice.domain.models.movie;

import java.math.BigDecimal;

public class CinemaMovieTicketPriceUpdating {
    private String cinemaName;
    private BigDecimal movieTicketPrice;

    public CinemaMovieTicketPriceUpdating() {
        //empty for framework
    }

    public CinemaMovieTicketPriceUpdating(String cinemaName, BigDecimal movieTicketPrice) {
        this.cinemaName = cinemaName;
        this.movieTicketPrice = movieTicketPrice;
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

    @Override
    public String toString() {
        return "CinemaMovieTicketPriceUpdating{" +
                "cinemaName='" + cinemaName + '\'' +
                ", movieTicketPrice=" + movieTicketPrice +
                '}';
    }
}
