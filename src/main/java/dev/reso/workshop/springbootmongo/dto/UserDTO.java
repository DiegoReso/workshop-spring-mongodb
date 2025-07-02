package dev.reso.workshop.springbootmongo.dto;

import dev.reso.workshop.springbootmongo.domain.Post;
import dev.reso.workshop.springbootmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class UserDTO {

    private String id;
    private String name;
    private String email;


    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
    }
}
