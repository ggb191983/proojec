package es.proojec.store.entities;

import es.proojec.domain.models.enums.StudiesType;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "challenges")
public class Challenge implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    private String title;
    private String description;
    private String picture;
    private String resources;
    private String video;
    private int duration;
    private int rating;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", foreignKey = @ForeignKey(name = "fk_challenge_category"))
    private Category category;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_application_date")
    private Date endCandidatureDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_challenge_Date")
    private Date endChallengeDate;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Label> labels;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_challenge_user"))
    private User author;

    @Enumerated(EnumType.STRING)
    private StudiesType studiesType;

    @OneToMany(mappedBy = "challenge", cascade = CascadeType.ALL)
    private List<Application> applications;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
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

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public StudiesType getStudiesType() {
        return studiesType;
    }

    public void setStudiesType(StudiesType studiesType) {
        this.studiesType = studiesType;
    }

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }
}
