package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ThesisDTO extends ObjectDTO {

    private Long id;
    private String title;
    private String description;
    private String picture;
    private String video;
    private String summary;
    private String link;
    private Date createAt;
    private int rating;
    private StudiesType studiesType;
    private CategoryDTO category;
    private UniversityDTO university;
    private UserDTO author;
    private List<LabelDTO> labels;
    private List<CommentDTO> comments;

}
