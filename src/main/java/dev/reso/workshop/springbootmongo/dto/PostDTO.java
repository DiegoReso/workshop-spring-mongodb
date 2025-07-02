package dev.reso.workshop.springbootmongo.dto;


import dev.reso.workshop.springbootmongo.domain.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PostDTO {

    private String id;
    private Date date;
    private String title;
    private String body;
    private UserDTO author;
    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO(Post post){
        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = new UserDTO(post.getAuthor());
        comments = post.getComments().stream().map(CommentDTO::new).toList();
    }

}
