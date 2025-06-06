package org.dmytr.less_42_spring_data.repository;

import org.dmytr.less_42_spring_data.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    List<User> findByEmailContaining(String s);
}
