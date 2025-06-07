package org.dmytr.less_42_spring_data.repository;

import org.dmytr.less_42_spring_data.dto.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findPostsByUserId(int userId);
}
