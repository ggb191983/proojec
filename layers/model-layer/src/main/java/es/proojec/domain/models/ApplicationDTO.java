package es.proojec.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ApplicationDTO extends ObjectDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String summary;
    private String video;
    private String description;
    private String url;
    private String status;
    private Date startDate;
    private Date endDate;
    private String tutor;
    private ChallengeDTO challenge;
    private StudentDTO student;
}
