package es.proojec.domain.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 07/09/2017.
 */
public class Challenge {

    private String title;
    private String description;
    private Category category;
    private int duration;
    private List<Comment> comments;
    private String picture;
    private String resources;
    private String video;
    private Date createdAt;
    private Date endCandidatureDate;
    private Date endChallengeDate
    private Label labels;
    private User author;
    private StudiesType: {type: String, enum: ['Degree', 'Master', 'Doctorate Degree']},
    private List<Candidature> candidaturesAssigned;
    private List<Application> applications;
    private int rating;
}
