package es.proojec.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class CategoryDTO extends ObjectDTO {

    private String name;
    private String nameEs;
    private String color;

    @JsonIgnore
    private UserDTO user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameEs() {
        return nameEs;
    }

    public void setNameEs(String nameEs) {
        this.nameEs = nameEs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
