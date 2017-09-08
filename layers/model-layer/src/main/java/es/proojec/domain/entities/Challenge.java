package es.proojec.domain.entities;

import es.proojec.domain.models.StudiesType;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
    private Date endChallengeDate;
    private Label labels;
    private User author;

    @Enumerated(EnumType.STRING)
    private StudiesType studiesType;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Application> applications;

    private int rating;
}
