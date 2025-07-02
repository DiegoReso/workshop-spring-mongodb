package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.domain.Post;
import dev.reso.workshop.springbootmongo.dto.PostDTO;
import dev.reso.workshop.springbootmongo.dto.UserDTO;
import dev.reso.workshop.springbootmongo.resource.util.URL;
import dev.reso.workshop.springbootmongo.service.PostService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO postDTO = new PostDTO(service.findById(id));
        return ResponseEntity.ok(postDTO);
    }
}
