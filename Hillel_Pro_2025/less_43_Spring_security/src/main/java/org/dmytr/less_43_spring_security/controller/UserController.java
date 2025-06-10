package org.dmytr.less_43_spring_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/user_api")
public class UserController {

    @GetMapping("/public")

    public String publicPage() {
        return "redirect:https://skillzzy.com";
    }

    @GetMapping("/user")
    @ResponseBody
    public String userPage() {
        return "User page: Welcome user";
    }

    @GetMapping("/admin")
    @ResponseBody
    public String adminPage() {
        return "Admin page: Welcome admin";
    }


}
