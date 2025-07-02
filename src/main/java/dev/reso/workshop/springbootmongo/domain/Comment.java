package dev.reso.workshop.springbootmongo.domain;


import dev.reso.workshop.springbootmongo.dto.CommentDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;
    private String text;
    private Date date;
    private User author;

    public Comment(CommentDTO commentDTO){
        id = commentDTO.getId();
        text = commentDTO.getText();
        date = commentDTO.getDate();
        author = new User(commentDTO.getAuthor());
    }
}
