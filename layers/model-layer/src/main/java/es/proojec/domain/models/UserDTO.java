package es.proojec.domain.models;

import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class UserDTO extends ObjectDTO {

    private Long id;
    private String userName;
    private String email;
    private String password;
    private String description;
    private String accessToken;
    private String facebookURL;
    private String linkedinURL;
    private List<CategoryDTO> categories;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
