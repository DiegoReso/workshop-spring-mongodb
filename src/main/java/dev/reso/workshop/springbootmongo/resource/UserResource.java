package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.domain.User;
import dev.reso.workshop.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<User>>  getUsers() {
        List<User> users = service.findAll();
        return ResponseEntity.ok(users);

    }

}
