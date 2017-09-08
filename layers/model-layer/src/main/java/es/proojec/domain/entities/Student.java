package es.proojec.domain.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by ggb191983 on 07/09/2017.
 */
public class Student extends User {
    private String name;
    private String surname;
    private Studies studies;
    private University university;
    private Challenge favouriteChallenges;
}
