package es.proojec.domain.models;

import java.time.LocalDateTime;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class ApplicationDTO extends ObjectDTO {

    private String summary;
    private String video;
    private String description;
    private String url;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime  endDate;
    private String tutor;
    private ChallengeDTO challenge;
    private StudentDTO student;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public ChallengeDTO getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeDTO challenge) {
        this.challenge = challenge;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
}
