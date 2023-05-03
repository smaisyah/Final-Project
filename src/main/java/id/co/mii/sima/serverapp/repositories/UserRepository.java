package id.co.mii.sima.serverapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.co.mii.sima.serverapp.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
  Optional<User> findByUsernameOrEmployee_Email(String username, String email);
}