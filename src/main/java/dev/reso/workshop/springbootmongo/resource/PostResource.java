package dev.reso.workshop.springbootmongo.resource;

import dev.reso.workshop.springbootmongo.dto.PostDTO;
import dev.reso.workshop.springbootmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
