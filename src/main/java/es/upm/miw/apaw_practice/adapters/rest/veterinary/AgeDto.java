package es.upm.miw.apaw_practice.adapters.rest.veterinary;

public class AgeDto {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "AgeDto{" +
                "age=" + age +
                '}';
    }
}
