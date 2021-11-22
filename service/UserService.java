package com.example.serve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.serve.dto.UserDTO;
import com.example.serve.entity.UserEntity;

@Service
public interface UserService {

	UserEntity save(UserEntity product);

 
     Optional<UserEntity> findById(Long id);
 
    List<UserEntity> findAll();


	
    
    


	
	
}
