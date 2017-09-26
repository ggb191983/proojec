package es.proojec.domain.models;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class LabelDTO extends ObjectDTO {

    private String name;
    private ChallengeDTO challenge;
    private ThesisDTO thesis;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
