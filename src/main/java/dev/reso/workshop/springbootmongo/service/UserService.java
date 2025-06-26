package dev.reso.workshop.springbootmongo.service;

import dev.reso.workshop.springbootmongo.domain.User;
import dev.reso.workshop.springbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }
}
