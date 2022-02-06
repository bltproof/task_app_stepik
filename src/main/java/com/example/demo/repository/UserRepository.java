package com.example.demo.repository;

import com.example.demo.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query(value = "SELECT u FROM User u WHERE u.login = ?1")
    Optional<User> findByLogin(@Param("login") String login);
}
