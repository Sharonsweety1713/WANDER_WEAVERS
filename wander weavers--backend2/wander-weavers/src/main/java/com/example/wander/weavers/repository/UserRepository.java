package com.example.wander.weavers.repository;
// import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.example.wander.weavers.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
@Query("SELECT u FROM User u where u.username=?1")
    List<User> findByUsername(String username);

    @Query("SELECT u FROM User u ORDER BY u.username")
    List<User> findAllUsersSortedByUsername();

    
}
