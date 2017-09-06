package es.proojec.store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import es.proojec.domain.entities.User;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}