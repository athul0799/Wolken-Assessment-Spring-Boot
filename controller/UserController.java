package com.example.serve.controller;
import java.util.List;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import com.example.serve.controller.UserController;
import com.example.serve.dto.TicketDTO;
import com.example.serve.dto.UserDTO;
import com.example.serve.service.UserService;
import com.example.serve.entity.UserEntity;
import com.example.serve.repository.UserRepository;
import com.example.serve.ResourceNotFoundExcepetion;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

//@RequestMapping("/users")
public class UserController {
	//private Logger logger=LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    private UserService userService;
 
    @GetMapping("getAllUsers")
    public List<UserEntity> getUserList()/*@RequestParam String userKey*/ {
        //log.info("User: {}", userKey);
        return userService.findAll();
    }
 
    @GetMapping("getUserList")
    public UserEntity getUser(@PathVariable(value = "userId") long userId) {
       return userService.findById(userId).orElseThrow(() -> new ResourceNotFoundExcepetion("userId " + userId + " not found"));
    	
    }
 
    @PostMapping("addUser")
    public String addUser(@RequestBody UserEntity user) {
        userService.save(user);
        return "user added";
    }

    @PostMapping("updateUser")
    public String updateUser(@PathVariable(value = "userId") Long userId, @RequestBody UserEntity user) {
        return userService.findById(userId).map(p -> {
            p.setFirstName(user.getFirstName());
            
            p.setCode(user.getCode());
            userService.save(p);
            return "User updated";
        }).orElseThrow(() -> new ResourceNotFoundExcepetion("id " + userId + " not found"));
    }
    
    
    
 }
