package es.upm.miw.apaw_practice.adapters.rest.sportcentre;

public class PhoneDto {
    private int phone;

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "PhoneDto{" +
                "phone=" + phone +
                '}';
    }
}
