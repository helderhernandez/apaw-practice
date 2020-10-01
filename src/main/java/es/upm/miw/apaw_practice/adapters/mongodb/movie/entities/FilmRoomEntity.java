package es.upm.miw.apaw_practice.adapters.mongodb.movie.entities;

public class FilmRoomEntity {
    private int numberOfSeats;
    private int numberFilmRoom;
    private boolean laserScreen;

    public FilmRoomEntity() {
        //empty from framework
    }

    public FilmRoomEntity(int numberOfSeats, int numberFilmRoom, boolean laserScreen) {
        this.numberOfSeats = numberOfSeats;
        this.numberFilmRoom = numberFilmRoom;
        this.laserScreen = laserScreen;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberFilmRoom() {
        return numberFilmRoom;
    }

    public void setNumberFilmRoom(int numberFilmRoom) {
        this.numberFilmRoom = numberFilmRoom;
    }

    public boolean isLaserScreen() {
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
