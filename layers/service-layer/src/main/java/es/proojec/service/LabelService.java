package es.proojec.service;

import es.proojec.store.entities.Label;

/**
 * Created by ggb191983 on 09/09/2017.
 */
public interface LabelService {
    Label save(Label entity);

    Label find(Long id);

    Iterable<Label> findAll();
}
