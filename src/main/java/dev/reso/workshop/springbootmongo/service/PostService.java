package dev.reso.workshop.springbootmongo.service;

import dev.reso.workshop.springbootmongo.domain.Post;
import dev.reso.workshop.springbootmongo.repository.PostRepository;
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
}
