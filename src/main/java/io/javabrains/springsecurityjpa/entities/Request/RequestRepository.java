package io.javabrains.springsecurityjpa.entities.Request;

import io.javabrains.springsecurityjpa.entities.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RequestRepository extends JpaRepository<Request, Long> {

}
