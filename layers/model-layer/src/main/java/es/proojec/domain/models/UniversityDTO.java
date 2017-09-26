package es.proojec.domain.models;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class UniversityDTO extends ObjectDTO {

    private String name;
    private String nameEs;

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
}
