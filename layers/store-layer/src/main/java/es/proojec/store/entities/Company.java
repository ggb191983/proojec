package es.proojec.store.entities;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "companies")
@DiscriminatorValue(value = "Company")
public class Company extends User implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="thesis_id", foreignKey = @ForeignKey(name = "fk_user_thesis"))
    private Thesis favouriteThesis;

    public Thesis getFavouriteThesis() {
        return favouriteThesis;
    }

    public void setFavouriteThesis(Thesis favouriteThesis) {
        this.favouriteThesis = favouriteThesis;
    }
}
