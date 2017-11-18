package es.proojec.domain.models;

import java.time.LocalDateTime;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class CommentDTO extends ObjectDTO {

    private String content;
    private LocalDateTime createdAt;
    private UserDTO user;
    private ChallengeDTO challenge;
    private ThesisDTO thesis;

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public ChallengeDTO getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeDTO challenge) {
        this.challenge = challenge;
    }

    public ThesisDTO getThesis() {
        return thesis;
    }

    public void setThesis(ThesisDTO thesis) {
        this.thesis = thesis;
    }
}
