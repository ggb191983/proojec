package es.proojec.store.repositories;

import es.proojec.store.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {


}