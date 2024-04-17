package com.holidevs.service_deserialize_to_db.Repository;
import com.holidevs.service_deserialize_to_db.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
