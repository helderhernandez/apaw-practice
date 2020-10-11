package es.upm.miw.apaw_practice.adapters.rest.transport;

public class WorkedHoursExtraDto {
    private int workedHours;

    public WorkedHoursExtraDto() {
        //Empty for framework
    }

    public WorkedHoursExtraDto(Integer workedHours) {
        this.workedHours = workedHours;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }

    @Override
    public String toString() {
        return "WorkedHoursExtraDto{" +
                "workedHours=" + workedHours +
                '}';
    }
}
