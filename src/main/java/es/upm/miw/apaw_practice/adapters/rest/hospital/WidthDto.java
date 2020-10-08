package es.upm.miw.apaw_practice.adapters.rest.hospital;


import es.upm.miw.apaw_practice.domain.models.hospital.Bed;

public class WidthDto {

    private String width;

    public WidthDto(){
        //empty for framework
    }

    public WidthDto(Bed bed){
        this.width=String.valueOf(bed.getWidth());
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "WidthDto{" +
                "width=" + width +
                '}';
    }
}
