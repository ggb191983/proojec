package es.proojec.store.entities;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@DiscriminatorValue(value = "Company")
public class Company extends User implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="thesis_id", foreignKey = @ForeignKey(name = "fk_user_thesis"))
    private Thesis favouriteThesis;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Thesis getFavouriteThesis() {
        return favouriteThesis;
    }

    public void setFavouriteThesis(Thesis favouriteThesis) {
        this.favouriteThesis = favouriteThesis;
    }
}
