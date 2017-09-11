package es.proojec.store.entities;

import es.proojec.domain.models.enums.StudiesType;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "students")
@DiscriminatorColumn(name = "user_type")
@DiscriminatorValue(value = "Student")
public class Student extends User implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    private String name;
    private String surname;

    @Enumerated(EnumType.STRING)
    private StudiesType studies;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="university_id", foreignKey = @ForeignKey(name = "fk_student_university"))
    private University university;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="challenge_id", foreignKey = @ForeignKey(name = "fk_student_challenge"))
    private Challenge favouriteChallenges;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudiesType getStudies() {
        return studies;
    }

    public void setStudies(StudiesType studies) {
        this.studies = studies;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public Challenge getFavouriteChallenges() {
        return favouriteChallenges;
    }

    public void setFavouriteChallenges(Challenge favouriteChallenges) {
        this.favouriteChallenges = favouriteChallenges;
    }
}
