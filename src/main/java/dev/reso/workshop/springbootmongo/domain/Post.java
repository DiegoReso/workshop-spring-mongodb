package dev.reso.workshop.springbootmongo.domain;

import dev.reso.workshop.springbootmongo.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "post")
public class Post {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private User author;
    private List<Comment> comments = new ArrayList<>();


    public Post(PostDTO post) {
        id = post.getId();
        date = post.getDate();
        title = post.getTitle();
        body = post.getBody();
        author = new User(post.getAuthor());
        comments = post.getComments().stream().map(Comment::new).toList();
    }
}
