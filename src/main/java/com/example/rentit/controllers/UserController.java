package com.example.rentit.controllers;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;

import com.example.rentit.models.User;
import com.example.rentit.repositories.*;
import com.example.rentit.assemblers.*;
import com.example.rentit.exceptions.UserNotFoundException;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    private final UserRepository repository;
    private final UserResourceAssembler assembler;

    UserController(UserRepository repository, UserResourceAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @PostMapping("/")
    ResponseEntity<?> newUser(@RequestBody User newUser) throws URISyntaxException {

        User user = new User();
        user.setFirstname(newUser.getFirstname());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassowrd());
        
        Resource<User> resource = assembler.toResource(repository.save(user));

        return ResponseEntity
            .created(new URI(resource.getId().expand().getHref()))
            .body(resource);
    }

    @GetMapping("/")
	public Resources<Resource<User>> all() {
        List<Resource<User>> users = repository.findAll().stream()
            .map(assembler::toResource)
            .collect(Collectors.toList());

        return new Resources<>(users, 
            linkTo(methodOn(UserController.class).all()).withSelfRel());
    }

    @GetMapping("/{id}")
    public Resource<User> one(@PathVariable Long id) {
        User user = repository.findById(id)
            .orElseThrow(() -> new UserNotFoundException(id));
        return assembler.toResource(user);
    }
}