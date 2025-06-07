package org.dmytr.less_42_spring_data.controller;

import lombok.RequiredArgsConstructor;
import org.dmytr.less_42_spring_data.dto.Post;
import org.dmytr.less_42_spring_data.dto.User;
import org.dmytr.less_42_spring_data.repository.UserRepository;
import org.dmytr.less_42_spring_data.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/newUser")
    public void createUser(@RequestBody User user) {
        userService.createUserWithPost(user,user.getPosts());
    }

    @GetMapping("/user/{name}")
    public User getUserByName(@PathVariable String name) {
        return userService.findUserByName(name);
    }

    @GetMapping("/users/{domain}")
    public List<User> getUsersByDomain(@PathVariable String domain) {
        return userService.findByEmailContaining(domain);
    }

    @GetMapping("/posts/{userId}")
    public List<Post> getPostsByUserId(@PathVariable int userId) {
        return userService.findPostsByUserId(userId);
    }
}
