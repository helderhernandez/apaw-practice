package es.upm.miw.apaw_practice.domain.models.project;

public class IssueDoneStatusUpdating {

    private String id;
    private Boolean done;

    public IssueDoneStatusUpdating() {
        //empty for framework
    }

    public IssueDoneStatusUpdating(String id, Boolean done) {
        this.id = id;
        this.done = done;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    @Override
    public String toString() {
        return "IssueDoneStatusUpdating{" +
                "id='" + id + '\'' +
                ", done=" + done +
                '}';
    }

}
