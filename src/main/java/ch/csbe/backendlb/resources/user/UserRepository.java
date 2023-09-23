package ch.csbe.backendlb.resources.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // You should use 'User' instead of 'Product' here
    List<User> findUsersById(Long id);

    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Long id);
}
