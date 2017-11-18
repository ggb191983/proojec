package es.proojec.store.entities;

import es.proojec.domain.models.enums.StudiesType;
import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "thesis")
public class Thesis implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    private String title;
    private String description;
    private String picture;
    private String video;
    private String summary;
    private String link;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    private int rating;

    @Enumerated(EnumType.STRING)
    private StudiesType studiesType;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", foreignKey = @ForeignKey(name = "fk_thesis_category"))
    private Category category;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="university_id", foreignKey = @ForeignKey(name = "fk_thesis_university"))
    private University university;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_thesis_user"))
    private User author;

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<Label> labels;

    @OneToMany(mappedBy = "thesis", cascade = CascadeType.ALL)
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
