package ro.digitalnation.warmhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.digitalnation.warmhome.models.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
