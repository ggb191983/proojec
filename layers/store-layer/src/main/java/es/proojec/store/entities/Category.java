package es.proojec.store.entities;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "categories")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    @Column(unique=true)
    private String name;

    @Column(name = "name_es")
    private String nameEs;
    private String color;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_category_user"))
    private User user;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
