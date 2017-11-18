package es.proojec.domain.models;

import es.proojec.domain.models.enums.StudiesType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ggb191983 on 08/09/2017.
 */
@ApiModel(value = "Challenge DTO", description = "Complete data of a Challenge DTO")
public class ChallengeDTO extends ObjectDTO {

    @ApiModelProperty(value="Title of the challenge", required=true, example="Listen to you", position=1)
    private String title;
    @ApiModelProperty(value="Description of the challenge", required=false, position=2)
    private String description;
    @ApiModelProperty(value="Picture of the challenge", required=false, position=3)
    private String picture;
    @ApiModelProperty(value="Resources of the challenge", required=false, position=4)
    private String resources;
    @ApiModelProperty(value="Video of the challenge", required=false, position=5)
    private String video;
    @ApiModelProperty(value="Duration of the challenge", required=true, position=6)
    private int duration;
    @ApiModelProperty(value="Rating of the challenge", required=false, position=7)
    private int rating;
    private CategoryDTO category;
    private List<CommentDTO> comments;
    @ApiModelProperty(value="Createion date of the challenge", required=true, position=8)
    private LocalDateTime  createdAt;
    @ApiModelProperty(value="End candidature date of the challenge", required=true, position=9)
    private LocalDateTime endCandidatureDate;
    @ApiModelProperty(value="End challenge date of the challenge", required=true, position=10)
    private LocalDateTime  endChallengeDate;
    private List<LabelDTO> labels;
    @ApiModelProperty(value="Author of the challenge", required=true, position=11)
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getEndCandidatureDate() {
        return endCandidatureDate;
    }

    public void setEndCandidatureDate(LocalDateTime endCandidatureDate) {
        this.endCandidatureDate = endCandidatureDate;
    }

    public LocalDateTime getEndChallengeDate() {
        return endChallengeDate;
    }

    public void setEndChallengeDate(LocalDateTime endChallengeDate) {
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
