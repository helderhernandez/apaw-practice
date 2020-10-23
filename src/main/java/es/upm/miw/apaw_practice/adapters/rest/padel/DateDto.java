package es.upm.miw.apaw_practice.adapters.rest.padel;

import java.time.LocalDateTime;

public class DateDto {
    private LocalDateTime date;

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "DateDto{" +
                "date=" + date +
                '}';
    }
}
