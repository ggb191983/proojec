package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ThesisDTO extends ObjectDTO {

    private String title;
    private String description;
    private String picture;
    private String video;
    private String summary;
    private String link;
    private LocalDateTime createAt;
    private int rating;
    private StudiesType studiesType;
    private CategoryDTO category;
    private UniversityDTO university;
    private UserDTO author;
    private List<LabelDTO> labels;
    private List<CommentDTO> comments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public StudiesType getStudiesType() {
        return studiesType;
    }

    public void setStudiesType(StudiesType studiesType) {
        this.studiesType = studiesType;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
