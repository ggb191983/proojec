package es.proojec.domain.entities;

import es.proojec.domain.models.StudiesType;

/**
 * Created by ggb191983 on 07/09/2017.
 */
public class Student extends User {
    private String name;
    private String surname;
    private StudiesType studies;
    private University university;
    private Challenge favouriteChallenges;
}
