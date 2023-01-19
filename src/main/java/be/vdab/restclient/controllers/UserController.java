package be.vdab.restclient.controllers;

import be.vdab.restclient.clients.jsonplaceholder.UserClient;
import be.vdab.restclient.dto.User;
import be.vdab.restclient.exceptions.UserNietGevondenException;
import org.springframework.aop.target.LazyInitTargetSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserClient userClient;

    public UserController(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("{id}")
    User findById(@PathVariable long id) {
        return userClient.findById(id).orElseThrow(UserNietGevondenException::new);
    }

    @GetMapping
    List<User> findAll() {
        return userClient.findAll();
    }
}
