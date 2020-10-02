package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

public class FilmRoomEntity {
    private Integer numberOfSeats;
    private Integer numberFilmRoom;
    private Boolean laserScreen;

    public FilmRoomEntity() {
        //empty from framework
    }

    public FilmRoomEntity(int numberOfSeats, int numberFilmRoom, boolean laserScreen) {
        this.numberOfSeats = numberOfSeats;
        this.numberFilmRoom = numberFilmRoom;
        this.laserScreen = laserScreen;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Integer getNumberFilmRoom() {
        return numberFilmRoom;
    }

    public void setNumberFilmRoom(int numberFilmRoom) {
        this.numberFilmRoom = numberFilmRoom;
    }

    public Boolean isLaserScreen() {
        return laserScreen;
    }

    public void setLaserScreen(boolean laserScreen) {
        this.laserScreen = laserScreen;
    }

    @Override
    public String toString() {
        return "FilmRoomEntity{" +
                "numberOfSeats=" + numberOfSeats +
                ", numberFilmRoom=" + numberFilmRoom +
                ", laserScreen=" + laserScreen +
                '}';
    }
}
