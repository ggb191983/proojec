package es.proojec.service;

import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

/**
 * Created by ggb191983 on 08/09/2017.
 */
public class AbstractManager<R extends PagingAndSortingRepository<E, ID>, E extends Serializable, ID extends Serializable>  {

    protected R repository;
    private Class<E> entityClass;
    private Class<ID> idClass;

    protected AbstractManager(final R repository) {
        this.repository = repository;
    }
}
