package be.vdab.restclient.clients.jsonplaceholder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

interface Requests {
    @GetExchange("users/{id}")
    UserResponse findById(@PathVariable long id);

    @GetExchange("users")
    UserResponse[] findAll();
}
