package dev.reso.workshop.springbootmongo.dto;

import dev.reso.workshop.springbootmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

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
