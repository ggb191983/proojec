package es.proojec.domain.models;

import java.util.Date;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class CommentDTO extends ObjectDTO {

    private Long id;
    private String content;
    private Date createdAt;
    private UserDTO user;
    private ChallengeDTO challenge;
    private ThesisDTO thesis;
}
