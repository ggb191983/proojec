package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class StudentDTO extends ObjectDTO {

    private String name;
    private String surname;
    private StudiesType studies;
    private UniversityDTO university;
    private ChallengeDTO favouriteChallenges;

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

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }

    public ChallengeDTO getFavouriteChallenges() {
        return favouriteChallenges;
    }

    public void setFavouriteChallenges(ChallengeDTO favouriteChallenges) {
        this.favouriteChallenges = favouriteChallenges;
    }
}
