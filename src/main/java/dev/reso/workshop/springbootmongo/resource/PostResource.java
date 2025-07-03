package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.domain.Post;
import dev.reso.workshop.springbootmongo.dto.PostDTO;
import dev.reso.workshop.springbootmongo.resource.util.URL;
import dev.reso.workshop.springbootmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostResource {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        return ResponseEntity.ok(service.findAllPosts().stream().map(PostDTO::new).toList());
    }

    @GetMapping("/titlesearch")
        public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "title", defaultValue = "") String title){
        String titleDecode = URL.decodeParam(title);
        List<Post> posts = service.findByTitle(titleDecode);
        List<PostDTO> postsDto = posts.stream().map(PostDTO::new).toList();
        return ResponseEntity.ok(postsDto);
    }

    @GetMapping("/commentsearch")
    public ResponseEntity<List<PostDTO>> findByComment(@RequestParam(value = "comment", defaultValue = "") String comment){
        String titleDecode = URL.decodeParam(comment);
        List<Post> posts = service.findByComment(titleDecode);
        List<PostDTO> postsDto = posts.stream().map(PostDTO::new).toList();
        return ResponseEntity.ok(postsDto);
    }

    @GetMapping("/authorsearch")
    public ResponseEntity<List<PostDTO>> findByAuthor(@RequestParam(value = "author", defaultValue = "") String author){
        String authorDecode = URL.decodeParam(author);
        List<PostDTO> postDTO = service.findByAuthor(authorDecode).stream().map(PostDTO::new).toList();
        return ResponseEntity.ok(postDTO);
    }

    @GetMapping("/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "minDate", defaultValue = "")String minDate,
            @RequestParam(value = "maxDate",  defaultValue = "")String maxDate){
        text = URL.decodeParam(text);
        Date min = URL.convertDate(minDate, new Date(0L));
        Date max = URL.convertDate(maxDate, new Date());
        List<PostDTO> postsDTO = service.fullSearch(text, min, max).stream().map(PostDTO::new).toList();
        return ResponseEntity.ok(postsDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO postDTO = new PostDTO(service.findById(id));
        return ResponseEntity.ok(postDTO);
    }
}
