package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.domain.User;
import dev.reso.workshop.springbootmongo.dto.UserDTO;
import dev.reso.workshop.springbootmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        UserDTO userDTO = new UserDTO(service.findById(id));
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO objDto){
        User user = service.fromDTO(objDto);
        user = service.insert(user);
        UserDTO userDto = new UserDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO objDto, @PathVariable String id){
        User user = service.fromDTO(objDto);
        user.setId(id);
        service.update(user,id);
        UserDTO userDTO = new UserDTO(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

}
