package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;

import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ChallengeDTO extends ObjectDTO {

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

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getEndCandidatureDate() {
        return endCandidatureDate;
    }

    public void setEndCandidatureDate(Date endCandidatureDate) {
        this.endCandidatureDate = endCandidatureDate;
    }

    public Date getEndChallengeDate() {
        return endChallengeDate;
    }

    public void setEndChallengeDate(Date endChallengeDate) {
        this.endChallengeDate = endChallengeDate;
    }

    public List<LabelDTO> getLabels() {
        return labels;
    }

    public void setLabels(List<LabelDTO> labels) {
        this.labels = labels;
    }

    public UserDTO getAuthor() {
        return author;
    }

    public void setAuthor(UserDTO author) {
        this.author = author;
    }

    public StudiesType getStudiesType() {
        return studiesType;
    }

    public void setStudiesType(StudiesType studiesType) {
        this.studiesType = studiesType;
    }

    public List<ApplicationDTO> getApplications() {
        return applications;
    }

    public void setApplications(List<ApplicationDTO> applications) {
        this.applications = applications;
    }
}
