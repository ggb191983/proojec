package es.proojec.store.entities;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "labels")
public class Label implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    @Column(unique=true)
    private String name;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="challenge_id", foreignKey = @ForeignKey(name = "fk_label_challenge"))
    private Challenge challenge;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="thesis_id", foreignKey = @ForeignKey(name = "fk_label_thesis"))
    private Thesis thesis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
