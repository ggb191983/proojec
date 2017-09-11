package es.proojec.store.repositories;

import es.proojec.store.entities.Application;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ggb191983 on 09/09/2017.
 */
@Repository
public interface ApplicationRepository extends PagingAndSortingRepository<Application, Long> {
}
