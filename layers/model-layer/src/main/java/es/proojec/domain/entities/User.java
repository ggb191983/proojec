package es.proojec.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Entity
public class User {
    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String email;
    private String password;
    private String facebookURL;
    private String accessToken;
    private String description;
    private String linkedinURL;
    private List<Category> categories;

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String lastname) {
        this.email = lastname;
    }

    @Override
    public String toString() {
        return "Person [userName=" + this.userName + ", email=" + this.email
                + "]";
    }

    public String getName() {
        return this.userName + " " + this.email;
    }
}