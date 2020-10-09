package es.upm.miw.apaw_practice.domain.models.veterinary;

public class AnimalAgeUpdating {
    private String id;
    private Integer age;

    public AnimalAgeUpdating() {
        //Empty for framework;
    }

    public AnimalAgeUpdating(String id, Integer age) {
        this.id = id;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AnimalAgeUpdating{" +
                "id='" + id + '\'' +
                ", age=" + age +
                '}';
    }
}
