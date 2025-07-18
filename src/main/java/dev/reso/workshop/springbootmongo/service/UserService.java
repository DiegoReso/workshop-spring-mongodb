package dev.reso.workshop.springbootmongo.service;

import dev.reso.workshop.springbootmongo.domain.User;
import dev.reso.workshop.springbootmongo.repository.UserRepository;
import dev.reso.workshop.springbootmongo.service.exception.ObjectNotFoundException;
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

    public User findById(String id){
        return repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));
    }

    public User insert(User obj){
        return repository.insert(obj);
    }


    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }

    public User update(User userRequest, String id) {
        User newObj = findById(id);
        newObj.setName(userRequest.getName());
        newObj.setEmail(userRequest.getEmail());
        return repository.save(newObj);
    }

}
