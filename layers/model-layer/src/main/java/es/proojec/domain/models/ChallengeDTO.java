package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ChallengeDTO extends ObjectDTO {

    private Long id;
    private String title;
    private String description;
    private String picture;
    private String resources;
    private String video;
    private int duration;
    private int rating;
    private CategoryDTO category;
    private List<CommentDTO> comments;
    private Date createdAt;
    private Date endCandidatureDate;
    private Date endChallengeDate;
    private List<LabelDTO> labels;
    private UserDTO author;
    private StudiesType studiesType;
    private List<ApplicationDTO> applications;
}
