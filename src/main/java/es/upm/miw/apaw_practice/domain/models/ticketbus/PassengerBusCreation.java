package es.upm.miw.apaw_practice.domain.models.ticketbus;


public class PassengerBusCreation {

    private String docIdentify;
    private String name;
    private String familyName;
    private String phone;
    private String email;
    private Boolean accesibility;

    public PassengerBusCreation() {
        //empty from framework
    }

    public PassengerBusCreation(String docIdentify, String name, String familyName, String phone, String email, Boolean accesibility) {
        this.docIdentify = docIdentify;
        this.name = name;
        this.familyName = familyName;
        this.phone = phone;
        this.email = email;
        this.accesibility = accesibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAccesibility() {
        return accesibility;
    }

    public void setAccesibility(Boolean accesibility) {
        this.accesibility = accesibility;
    }

    public String getDocIdentify() {
        return docIdentify;
    }

    public void setDocIdentify(String docIdentify) {
        this.docIdentify = docIdentify;
    }

    @Override
    public String toString() {
        return "PassengerBusCreation{" +
                "docIdentify='" + docIdentify + '\'' +
                ", name='" + name + '\'' +
                ", familyName='" + familyName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", accesibility=" + accesibility +
                '}';
    }
}
