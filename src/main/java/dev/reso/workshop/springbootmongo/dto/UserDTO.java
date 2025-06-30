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
    private List<PostDTO> posts = new ArrayList<>();

    public UserDTO(User user){
        id = user.getId();
        name = user.getName();
        email = user.getEmail();
        for(Post post : user.getPosts()){
            posts.add(new PostDTO(post));
        }
    }
}
