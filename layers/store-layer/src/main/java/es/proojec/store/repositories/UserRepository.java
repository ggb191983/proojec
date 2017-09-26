package es.proojec.store.repositories;

import es.proojec.store.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by ggb191983 on 06/09/2017.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE LOWER(u.email) = LOWER(:email)")
    User findByEmail(@Param("email") String email);
    @Query("SELECT u FROM User u WHERE LOWER(u.username) = :username")
    User findByUsername(String username);
}