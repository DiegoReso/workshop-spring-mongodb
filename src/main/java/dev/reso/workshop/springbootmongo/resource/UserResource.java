package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.dto.UserDTO;
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
    public ResponseEntity<List<UserDTO>>  getUsers() {
        List<UserDTO> usersDTO = service.findAll().stream().map(UserDTO::new).toList();
        return ResponseEntity.ok(usersDTO);
    }

}
