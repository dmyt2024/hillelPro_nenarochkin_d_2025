package org.dmytr.less_42_spring_data_jpa.repository;

import org.dmytr.less_42_spring_data_jpa.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);
    User findByEmailLike(String email);
}
