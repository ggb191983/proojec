package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class StudentDTO extends ObjectDTO {

    private Long id;
    private String name;
    private String surname;
    private StudiesType studies;
    private UniversityDTO university;
    private ChallengeDTO favouriteChallenges;
}
