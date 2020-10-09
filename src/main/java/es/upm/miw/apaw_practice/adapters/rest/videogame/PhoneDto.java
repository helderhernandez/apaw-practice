package es.upm.miw.apaw_practice.adapters.rest.videogame;

public class PhoneDto {

    private Integer phone;

    public PhoneDto(){

    }

    public PhoneDto(Integer phone) { this.phone = phone; }

    public Integer getPhone() { return phone; }

    public void setPhone(Integer phone) { this.phone = phone; }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "phone=" + phone +
                '}';
    }
}
