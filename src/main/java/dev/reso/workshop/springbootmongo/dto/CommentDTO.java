package dev.reso.workshop.springbootmongo.dto;

import dev.reso.workshop.springbootmongo.domain.Comment;
import dev.reso.workshop.springbootmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@NoArgsConstructor
@Data
public class CommentDTO {

    private String id;
    private String text;
    private Date date;
    private UserDTO author;

    public CommentDTO(Comment comment){
        id = comment.getId();
        text = comment.getText();
        date = comment.getDate();
        author = new UserDTO(comment.getAuthor());
    }
}
