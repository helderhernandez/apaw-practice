package es.upm.miw.apaw_practice.adapters.rest.movie;

public class AgeDto {
    private Integer age;

    public AgeDto(Integer age) {
        this.age = age;
    }

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
