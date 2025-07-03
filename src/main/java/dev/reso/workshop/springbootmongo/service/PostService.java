package dev.reso.workshop.springbootmongo.service;

import dev.reso.workshop.springbootmongo.domain.Post;
import dev.reso.workshop.springbootmongo.domain.User;
import dev.reso.workshop.springbootmongo.repository.PostRepository;
import dev.reso.workshop.springbootmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<Post> findAllPosts(){
        return repository.findAll();
    }

    public List<Post> findByTitle(String title){
        return repository.findPostsByTitleContainingIgnoreCase(title);
    }

    public Post findById(String id) {
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public List<Post> findByComment(String comment){
        return repository.findByComments_TextContainingIgnoreCase(comment);
    }

    public List<Post> findByAuthor(String author){
        return repository.findByAuthor(author);
    }
}
