package es.proojec.domain.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

/**
 * Created by ggb191983 on 07/09/2017.
 */
public class Application {
    private Student student;
    private String summary;
    private String video;
    private String description;
    private String url;
    private String status;
    private Date startDate;
    private Date endDate;
    private String tutor;

    @ManyToOne
    @JoinColumn(name = "challenge_application_id")
    private Challenge challenge;
}
