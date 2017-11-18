package es.proojec.store.entities;

import org.springframework.data.annotation.ReadOnlyProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by ggb191983 on 07/09/2017.
 */
@Entity
@Table(name = "comments")
public class Comment implements Serializable {

    @Id
    @GeneratedValue
    @ReadOnlyProperty
    private Long id;

    private String content;

    @Column(name = "create_at")
    private LocalDateTime createdAt;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id", foreignKey = @ForeignKey(name = "fk_comment_user"))
    private User user;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="challenge_id", foreignKey = @ForeignKey(name = "fk_comment_challenge"))
    private Challenge challenge;

    @OneToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="thesis_id", foreignKey = @ForeignKey(name = "fk_comment_thesis"))
    private Thesis thesis;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public Thesis getThesis() {
        return thesis;
    }

    public void setThesis(Thesis thesis) {
        this.thesis = thesis;
    }
}
