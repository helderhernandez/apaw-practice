package es.upm.miw.apaw_practice.adapters.rest.videogame;

public class NickNameDto {

    private String name;

    public NickNameDto() {

    }

    public NickNameDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "NickNameDto{" +
                "name='" + name + '\'' +
                '}';
    }
}
