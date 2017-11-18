package es.proojec.domain.models;

import java.io.Serializable;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public class ObjectDTO implements Serializable {
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
