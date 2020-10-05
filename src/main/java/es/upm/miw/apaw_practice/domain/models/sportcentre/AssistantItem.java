package es.upm.miw.apaw_practice.domain.models.sportcentre;

public class AssistantItem {

    private int phone;

    public AssistantItem() {
        //Empty from framework
    }

    public AssistantItem(int phone) {
        this.phone = phone;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AssistantItem{" +
                "phone=" + phone +
                '}';
    }
}


