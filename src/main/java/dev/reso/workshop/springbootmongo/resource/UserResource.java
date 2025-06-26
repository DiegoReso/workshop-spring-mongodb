package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<List<User>>  getUsers() {

        List<User> users = List.of(
                new User(1L, "John Doe", "jhonemaiol@email.com"),
                new User(2L, "Jane Doe", "janeemail@email.com"));

        return ResponseEntity.ok(users);

    }

}
