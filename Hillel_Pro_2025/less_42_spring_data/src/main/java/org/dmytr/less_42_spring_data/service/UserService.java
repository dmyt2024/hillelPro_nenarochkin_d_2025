package org.dmytr.less_42_spring_data.service;

import lombok.RequiredArgsConstructor;
import org.dmytr.less_42_spring_data.dto.Post;
import org.dmytr.less_42_spring_data.dto.User;
import org.dmytr.less_42_spring_data.exeption.ProhibitedEmailExeption;
import org.dmytr.less_42_spring_data.repository.PostRepository;
import org.dmytr.less_42_spring_data.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Transactional
    public void createUserWithPost(User user,List<Post> posts) {
        User newUser = userRepository.save(user);
        if (user.getEmail().endsWith("@banned.com")) {
            throw new ProhibitedEmailExeption("Prohibited email!");
        }
        for (Post post : posts) {
            post.setUser(newUser);
            postRepository.save(post);
        }
    }

    public User findUserByName(String userName) {
        return userRepository.findByName(userName);
    }

    public List<User> findByEmailContaining(String domain) {
        return userRepository.findByEmailContaining(domain);
    }

    public List<Post> findPostsByUserId(int userId){
        return postRepository.findPostsByUserId(userId);
    }




}
