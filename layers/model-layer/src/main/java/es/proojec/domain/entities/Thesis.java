package es.proojec.domain.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 07/09/2017.
 */
public class Thesis {
    private String title;
    private String description;
    private Category category;
    private Date creationDate;
    private List<Comment> comments;
    private String picture;
    private String video;
    private List<Label> labels;
    private StudiesType studiesType; //{type: String, enum: ['Degree', 'Master', 'Doctorate Degree']},
    private int rating;
    private String summary;
    private String link;
    private University university;
    private User author;
}
