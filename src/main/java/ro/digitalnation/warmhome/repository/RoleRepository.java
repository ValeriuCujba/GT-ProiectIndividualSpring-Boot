package ro.digitalnation.warmhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ro.digitalnation.warmhome.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Role findByName(String name);
}
